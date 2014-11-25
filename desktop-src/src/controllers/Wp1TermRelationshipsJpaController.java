/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.TermRelationships;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author David Daniel Kurtz <daviddanielkurtz@gmail.com>
 */
public class Wp1TermRelationshipsJpaController extends AbstractController<TermRelationships> implements Serializable {

    public Wp1TermRelationshipsJpaController(EntityManagerFactory emf) {
        super(TermRelationships.class, emf);
    }

    public void updateStatus(long orderId, String orderStatus) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            String completedId = findIdOfStatus(em, orderStatus);
            List<Object[]> wtr = findAllOrders(em, orderId);

            for (Object[] wp1TermRelationships : wtr) {
                em.createNativeQuery("UPDATE  `pizza`.`pizzaterm_relationships` SET  `term_taxonomy_id` =?1  WHERE  `pizzaterm_relationships`.`object_id` = ?2 AND `pizzaterm_relationships`.`term_taxonomy_id` = ?3 ")
                        .setParameter(1, completedId).setParameter(2, orderId).setParameter(3, wp1TermRelationships[1]).executeUpdate();
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getLogger(Wp1TermRelationshipsJpaController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            em.close();
        }
    }

    private String findIdOfStatus(EntityManager em, String orderStatus) {
        String completedId = (String) em.createNativeQuery("SELECT t.term_id FROM pizzaterms t WHERE t.name = ?1").setParameter(1, orderStatus)
                .setMaxResults(1)
                .getSingleResult().toString();
        return completedId;
    }

    private List<Object[]> findAllOrders(EntityManager em, long orderId) {
        List<Object[]> wtr = em.createNativeQuery("SELECT * FROM pizzaterm_relationships t WHERE t.object_id = ?1")
                .setParameter(1, orderId)
                .getResultList();
        em.getTransaction().begin();
        return wtr;
    }
    
    
}
