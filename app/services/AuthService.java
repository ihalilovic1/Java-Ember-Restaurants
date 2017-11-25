package services;

import models.tables.User;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import java.util.UUID;

public class AuthService extends AbstractService {

    public String setToken(User user) {
        String token = UUID.randomUUID().toString();
        user.setToken(token);

        getEntityManager().merge(user);

        return token;
    }

    public User authenticate(String token) {
        EntityManager em = getEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);

        criteria.select(root);
        criteria.where(builder.equal(root.get("token"), token));

        try {
            return em.createQuery(criteria).getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
}
