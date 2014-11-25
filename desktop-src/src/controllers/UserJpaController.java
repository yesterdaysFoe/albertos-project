/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.exceptions.NonexistentEntityException;
import entities.User;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author David Daniel Kurtz <daviddanielkurtz@gmail.com>
 */
public class UserJpaController extends AbstractController<User> implements Serializable {

    public UserJpaController(EntityManagerFactory emf) {
        super(User.class, emf);
    }

    public User findUsername(String user) throws NonexistentEntityException {
        EntityManager em;
        try {
            em = getEntityManager();
            return (User) em.createQuery("SELECT u FROM User u WHERE u.username = ?1").setParameter(1, user).setMaxResults(1).getSingleResult();
        } catch (Exception e) {
            throw new NonexistentEntityException("Invalid user name:", e);
        }
    }
}
