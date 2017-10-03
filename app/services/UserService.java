package services;


import forms.LoginForm;
import models.tables.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.jpa.HibernateEntityManager;
import play.db.jpa.JPA;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserService extends AbstractService {

    public User register() {
        return new User();
    }

    public User login(LoginForm loginForm) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);

        criteria.select(root);
        criteria.where(builder.equal(root.get("email"), loginForm.getEmail()));
        criteria.where(builder.equal(root.get("password"), hash(loginForm.getPassword())));

        return getEntityManager().createQuery(criteria).getSingleResult();
    }
}
