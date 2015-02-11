/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Transactions;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import utils.MyUtil;

/**
 *
 * @author David Daniel Kurtz <daviddanielkurtz@gmail.com>
 */
public class TransactionsJpaController extends AbstractController<Transactions> implements Serializable {

    public TransactionsJpaController(EntityManagerFactory emf) {
        super(Transactions.class, emf);
    }

    public List<Object[]> findParrentTransactionByDate(Date start, Date end) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.createQuery("SELECT t.parrentTransaction.id, t.date,  t.customerName, SUM(t.price), SUM(t.totalPrice), t.invoice FROM Transactions t WHERE t.parrentTransaction.active = ?3 AND (t.date BETWEEN ?1 AND ?2) GROUP BY t.parrentTransaction.id ")
                    .setParameter(1, start)
                    .setParameter(2, end)
                    .setParameter(3, true)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Object[]> findPreviousCustomer() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.createQuery("SELECT t.customerName,  t.customerAddress, t.customerContactNumber, t.customerEmail FROM Transactions t GROUP BY t.customerName,  t.customerAddress, t.customerContactNumber, t.customerEmail ORDER BY t.customerName ASC")
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Transactions> findTransactionByParrent(long parrentId) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.createQuery("SELECT t FROM Transactions t WHERE t.parrentTransaction.id = ?1").setParameter(1, parrentId).getResultList();
        } finally {
            em.close();
        }
    }

    public Object[] listBestSellerProduct() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.createNativeQuery("SELECT product_name, SUM(qty) AS sum_qty FROM transactions GROUP BY product_id ORDER BY sum_qty DESC").getResultList().toArray();
        } finally {
            em.close();
        }
    }
    
    public String findLastId() {

        EntityManager em = null;
        try {
            em = getEntityManager();
            int invoice = (int) em.createNativeQuery("SELECT t.invoice FROM transactions t GROUP BY t.parrent_transaction ORDER BY t.parrent_transaction DESC").setMaxResults(1).getSingleResult();
            return MyUtil.df.format(invoice + 1);
        } catch (Exception e) {
//            e.printStackTrace();
            return MyUtil.df.format(1);
        } finally {
            em.close();
        }
    }
}
