/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.exceptions.NonexistentEntityException;
import entities.StocksHistory;
import entities.Postmeta;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import utils.MyUtil;

/**
 *
 * @author David Daniel Kurtz <daviddanielkurtz@gmail.com>
 */
public class Wp1PostmetaJpaController extends AbstractController<Postmeta> implements Serializable {

    public Wp1PostmetaJpaController(EntityManagerFactory emf) {
        super(Postmeta.class, emf);
    }

    public void updateStocks(int productId, int stocksToDeduct, String action, String comment) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Postmeta postmeta = (Postmeta) em.createNativeQuery("SELECT * FROM pizzapostmeta p WHERE p.post_id = ?1 AND p.meta_key = ?2 ").setParameter(1, productId).setParameter(2, "_stock").getSingleResult();
            
            final String currentQty = postmeta.getMetaValue().equals("") ? "0" : postmeta.getMetaValue();
            if (action.equals(MyUtil.STOCKIN)) {
                postmeta.setMetaValue("" + (Integer.parseInt(currentQty) + stocksToDeduct));
            } else {
                postmeta.setMetaValue("" + (Integer.parseInt(currentQty) - stocksToDeduct));
            }
            StocksHistoryJpaController controller = new StocksHistoryJpaController(config.Config.getInstance());
            controller.create(new StocksHistory(null, new Date(), stocksToDeduct, action, comment, productId));
            edit(postmeta);

        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Wp1PostmetaJpaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Wp1PostmetaJpaController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            em.close();
        }
    }
}
