/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import classes.Customer;
import classes.Orders;
import classes.ProductVariations;
import classes.Products;
import classes.Sell;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author David Daniel Kurtz <daviddanielkurtz@gmail.com>
 */
public class Wp1PostsJpaController extends AbstractController<Products> implements Serializable {

    public Wp1PostsJpaController(EntityManagerFactory emf) {
        super(Products.class, emf);
    }

    //<editor-fold defaultstate="collapsed" desc=" Orders-Related Code ">
    public List<Orders> findOrders() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            List<Orders> orderses = new ArrayList<>();
            em.getTransaction().begin();
            em.createNativeQuery("CREATE TEMPORARY TABLE IF NOT EXISTS "
                    + "billingFirstName AS (SELECT p.ID as ID, p.post_title, pm.meta_value as firstName FROM `pizzaposts` p,`pizzapostmeta` pm WHERE post_type = 'shop_order' and pm.post_id = p.ID and pm.meta_key = '_billing_first_name' ); ").executeUpdate();
            em.createNativeQuery("CREATE TEMPORARY TABLE IF NOT EXISTS "
                    + "billingLastName AS (SELECT p.ID as ID, p.post_title, pm.meta_value as lastName FROM `pizzaposts` p,`pizzapostmeta` pm WHERE post_type = 'shop_order' and pm.post_id = p.ID and pm.meta_key = '_billing_last_name' ); ").executeUpdate();
            em.createNativeQuery("CREATE TEMPORARY TABLE IF NOT EXISTS "
                    + "billingAddress AS (SELECT p.ID as ID, p.post_title, pm.meta_value as address FROM `pizzaposts` p,`pizzapostmeta` pm WHERE post_type = 'shop_order' and pm.post_id = p.ID and pm.meta_key = '_billing_address_1' ); ").executeUpdate();
            em.createNativeQuery("CREATE TEMPORARY TABLE IF NOT EXISTS "
                    + "billingEmail AS (SELECT p.ID as ID, p.post_title, pm.meta_value as email FROM `pizzaposts` p,`pizzapostmeta` pm WHERE post_type = 'shop_order' and pm.post_id = p.ID and pm.meta_key = '_billing_email' ); ").executeUpdate();
            em.createNativeQuery("CREATE TEMPORARY TABLE IF NOT EXISTS "
                    + "billingPhone AS (SELECT p.ID as ID, p.post_title, pm.meta_value as phone FROM `pizzaposts` p,`pizzapostmeta` pm WHERE post_type = 'shop_order' and pm.post_id = p.ID and pm.meta_key = '_billing_phone' ); ").executeUpdate();
            em.createNativeQuery("CREATE TEMPORARY TABLE IF NOT EXISTS "
                    + "billingTotalOrder AS (SELECT p.ID as ID, p.post_title, pm.meta_value as totalOrder FROM `pizzaposts` p,`pizzapostmeta` pm WHERE post_type = 'shop_order' and pm.post_id = p.ID and pm.meta_key = '_order_total' ); ").executeUpdate();
            em.createNativeQuery("CREATE TEMPORARY TABLE IF NOT EXISTS "
                    + "billingOrderStatus AS(SELECT post.ID as ID, term.name as orderStatus "
                    + "FROM pizzaposts post "
                    + "LEFT JOIN pizzaterm_relationships tr ON post.ID = tr.object_id "
                    + "LEFT JOIN pizzaterm_taxonomy tt ON tr.term_taxonomy_id = tt.term_taxonomy_id "
                    + "JOIN pizzaterms term ON tt.term_id = term.term_id "
                    + "WHERE post.post_type = 'shop_order' AND tt.parent = '0' AND term.name != 'completed'); ").executeUpdate();

            List<Object[]> oList = em.createNativeQuery("SELECT post.ID, post.post_title, f.firstName, l.lastName, a.address, e.email, ph.phone, o.totalOrder, s.orderStatus, post.post_date "
                    + "FROM pizzaposts post "
                    + "LEFT JOIN billingFirstName f ON f.ID = post.ID "
                    + "LEFT JOIN billingLastName l ON l.ID = post.ID "
                    + "LEFT JOIN billingAddress a ON a.ID = post.ID "
                    + "LEFT JOIN billingEmail e ON e.ID = post.ID "
                    + "LEFT JOIN billingPhone ph ON ph.ID = post.ID "
                    + "LEFT JOIN billingTotalOrder o ON o.ID = post.ID "
                    + "JOIN billingOrderStatus s ON s.ID = post.ID "
                    + "WHERE post.post_type = 'shop_order' and post_status = 'publish' ORDER BY post.ID DESC").getResultList();
            for (Object[] objects : oList) {
                Orders order = new Orders();
                order.setId(objects[0].toString());

                Customer c = new Customer();
                c.setFirstName((String) objects[2]);
                c.setLastName((String) objects[3]);
                c.setAddress((String) objects[4]);
                c.setEmail((String) objects[5]);
                c.setContactNo((String) objects[6]);
                order.setCustomer(c);

                order.setTotalOrder((String) objects[7]);
                order.setOrderDate(new SimpleDateFormat("MMM dd, yyyy @ hh:mm aa").format(objects[9]));
                order.setOrderStatus((String) objects[8]);
                orderses.add(order);
            }

            em.createNativeQuery("DROP TABLE billingFirstName;").executeUpdate();
            em.createNativeQuery("DROP TABLE billingLastName;").executeUpdate();
            em.createNativeQuery("DROP TABLE billingAddress;").executeUpdate();
            em.createNativeQuery("DROP TABLE billingEmail;").executeUpdate();
            em.createNativeQuery("DROP TABLE billingPhone;").executeUpdate();
            em.createNativeQuery("DROP TABLE billingTotalOrder;").executeUpdate();
            em.createNativeQuery("DROP TABLE billingOrderStatus;").executeUpdate();

            em.getTransaction().commit();

            return orderses;
        } finally {
            em.close();
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Sells-Related Code ">
    public List<Sell> findSells(int orderId) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            List<Sell> sells = new ArrayList<>();
            List<Object[]> p = em.createNativeQuery("SELECT * FROM pizzawoocommerce_order_items p WHERE p.order_id = ?1 ").setParameter(1, orderId).getResultList();
            for (Object[] w : p) {
                Sell s = new Sell();

                List<Object[]> wwoi = em.createNativeQuery("SELECT * FROM pizzawoocommerce_order_itemmeta p WHERE p.order_item_id = ?1 "
                        + "AND p.meta_key IN('_product_id' ,'_qty' ,'_line_subtotal'  ,'_line_total', '_variation_id') ")
                        .setParameter(1, w[0])
                        .getResultList();
                for (Object[] wo : wwoi) {
                    switch (wo[2].toString()) {
                        case "_product_id":
                            s.setTempProductId(wo[3].toString());
                            break;
                        case "_qty":
                            s.setQty(Integer.parseInt(wo[3].toString()));
                            break;
                        case "_line_subtotal":
                            s.setTotalPrice(wo[3].toString());
                            break;
                        case "_line_total":
                            s.setPrice(wo[3].toString());
                            break;
                        case "_variation_id":
                            s.setVariationID(wo[3].toString());
                            break;
                    }
                }

                sells.add(s);
            }
            return sells;
        } finally {
            em.close();
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Products-Related Code ">
    public List<Products> findProducts() {
        EntityManager em = null;
        try {
            em = getEntityManager();

            em.getTransaction().begin();

            em.getEntityManagerFactory().getCache().evictAll();

            List<Products> productses = new ArrayList<>();
            em.createNativeQuery("CREATE TEMPORARY TABLE "
                    + "price AS (SELECT p.ID as ID, p.post_title, pm.meta_value as price FROM `pizzaposts` p,`pizzapostmeta` pm WHERE (p.post_type = 'product' ) and pm.post_id = p.ID and pm.meta_key = '_price' ); ").executeUpdate();

            em.createNativeQuery("CREATE TEMPORARY TABLE "
                    + "sku AS (SELECT p.ID as ID, p.post_title, pm.meta_value as sku FROM `pizzaposts` p,`pizzapostmeta` pm WHERE (p.post_type = 'product' ) and pm.post_id = p.ID and pm.meta_key = '_sku' ); ").executeUpdate();

            em.createNativeQuery("CREATE TEMPORARY TABLE "
                    + "stock AS (SELECT p.ID as ID, p.post_title, pm.meta_value as stock FROM `pizzaposts` p,`pizzapostmeta` pm WHERE (p.post_type = 'product' ) and pm.post_id = p.ID and pm.meta_key = '_stock' ) ; ").executeUpdate();

            em.createNativeQuery("CREATE TEMPORARY TABLE "
                    + "category AS(SELECT post.ID as ID, term.name as category "
                    + "	FROM pizzaposts post"
                    + "	LEFT JOIN pizzaterm_relationships tr ON post.ID = tr.object_id "
                    + "	LEFT JOIN pizzaterm_taxonomy tt ON tr.term_taxonomy_id = tt.term_taxonomy_id "
                    + "	JOIN pizzaterms term ON tt.term_id = term.term_id "
                    + "	WHERE (post.post_type = 'product') AND tt.taxonomy = 'product_cat' AND tt.parent = '0'); ").executeUpdate();

            List<Object[]> list = em.createNativeQuery("SELECT post.ID, post.post_title, post.post_content, s.sku, st.stock, p.price, c.category "
                    + "FROM pizzaposts post "
                    + "LEFT JOIN price p ON p.ID = post.ID "
                    + "LEFT JOIN sku s ON s.ID = post.ID "
                    + "LEFT JOIN stock st ON st.ID = post.ID "
                    + "LEFT JOIN category c ON c.ID = post.ID "
                    + "WHERE (post.post_type = 'product') AND post.post_status = 'publish' ").getResultList();


            for (Object[] objects : list) {
//                System.out.println(objects);
                Products p1 = new Products();
                p1.setId(objects[0].toString());
                p1.setProductName((String) objects[1]);
                p1.setProductDetails((String) objects[2]);
                p1.setSku((String) objects[3]);
                p1.setRemainingQty((String) objects[4]);
                p1.setPrice((String) objects[5]);
                p1.setCategory((String) objects[6]);
                productses.add(p1);
            }
            em.createNativeQuery("DROP TABLE price;").executeUpdate();
            em.createNativeQuery("DROP TABLE sku;").executeUpdate();
            em.createNativeQuery("DROP TABLE stock;").executeUpdate();
            em.createNativeQuery("DROP TABLE category;").executeUpdate();

            em.getTransaction().commit();
            return productses;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
    //</editor-fold>

    public List<ProductVariations> findProductVariations(Long productId) {
        EntityManager em = null;
        try {
            System.out.println("retreving");
            em = getEntityManager();
            List<ProductVariations> pvList = new ArrayList<>();
            List<Object[]> listVar = em.createNativeQuery("SELECT p.ID, p.post_parent FROM  `pizzaposts` p LEFT JOIN `pizzapostmeta` pm ON pm.post_id = p.ID WHERE pm.meta_key = 'attribute_pa_size-slug' AND p.post_parent = ?1").setParameter(1, productId).getResultList();
            for (Object[] objects : listVar) {
                System.out.println(objects[0].toString());
                ProductVariations pv = new ProductVariations();
                pv.setId(objects[0].toString());
                pv.setParrentProduct(objects[1].toString());
                pvList.add(pv);
            }
            return pvList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    public Object variationPrice(Long productId) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Object price = em.createNativeQuery("SELECT pm.meta_value as price FROM `pizzapostmeta` pm WHERE pm.post_id = ?1 AND pm.meta_key = '_price' ").setParameter(1, productId).getSingleResult();
            return price;
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    public Object findVariationName(Long variationId) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Object price = em.createNativeQuery("SELECT pt.name as price FROM `pizzapostmeta` pm LEFT JOIN `pizzaterms` pt ON pm.meta_value = pt.slug WHERE pm.post_id = ?1 AND pm.meta_key = 'attribute_pa_size-slug' ").setParameter(1, variationId).getSingleResult();
            return price;
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    public String findInWooTax(String str, EntityManager em) {
        try {
            String attribName = (String) em.createNativeQuery("SELECT w.attrib_label FROM `pizzawoocommerce_attribute_taxonomies` w WHERE w.attribute_name = ?1").setParameter(1, str).getSingleResult();
            return attribName;
        } catch (Exception e) {
            return null;
        }
    }
}
