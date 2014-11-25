/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.StocksHistory;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author David Daniel Kurtz <daviddanielkurtz@gmail.com>
 */
public class StocksHistoryJpaController extends AbstractController<StocksHistory> implements Serializable {

    public StocksHistoryJpaController(EntityManagerFactory emf) {
        super(StocksHistory.class, emf);
    }

    public Collection<? extends StocksHistory> findByProductId(String id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.createQuery("SELECT s FROM StocksHistory s WHERE s.productId = ?1 ORDER BY s.date DESC").setParameter(1, Integer.parseInt(id)).getResultList();
        } finally {
            em.close();
        }
    }
}
