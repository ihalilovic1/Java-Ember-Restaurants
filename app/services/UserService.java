package services;


import models.tables.User;
import org.hibernate.jpa.HibernateEntityManager;
import org.hibernate.Session;
import play.db.jpa.JPA;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.EntityManager;


public class UserService {

    private JPAApi jpaApi;

    @Inject
    public UserService(JPAApi api) {
        this.jpaApi = api;
    }

    public User getUser() {

        EntityManager em = jpaApi.em();

        return em.getReference(User.class, 1);
    }
}
