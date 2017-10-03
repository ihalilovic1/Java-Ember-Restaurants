package services;

import org.hibernate.Session;
import org.hibernate.jpa.HibernateEntityManager;
import play.db.jpa.JPA;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public abstract class AbstractService {

    public AbstractService() {
    }

    public EntityManager getEntityManager() {
        return JPA.em();
    }

    //TODO: implement hashing
    public String hash(String password) {
        return password;
    }

}
