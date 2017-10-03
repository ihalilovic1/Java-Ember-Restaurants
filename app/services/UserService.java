package services;


import forms.LoginForm;
import forms.RegisterForm;
import models.tables.City;
import models.tables.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserService extends AbstractService {

    public User register(RegisterForm registerForm) {

        return null;
    }

    public User login(LoginForm loginForm) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);

        criteria.select(root);
        criteria.where(builder.equal(root.get("email"), loginForm.getEmail()));
        criteria.where(builder.equal(root.get("password"), hash(loginForm.getPassword())));
        try {
            return getEntityManager().createQuery(criteria).getSingleResult();
        } catch (Exception ex) {
            //TODO handle exceptions here
            return null;
        }

    }

    public User getUserById(Integer id) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);

        criteria.select(root);
        criteria.where(builder.equal(root.get("id"), id));

        try {
            return getEntityManager().createQuery(criteria).getSingleResult();
        } catch (Exception ex) {
            //TODO handle exceptions here
            return null;
        }
    }

    public City getCityByName(String name) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<City> criteria = builder.createQuery(City.class);
        Root<City> root = criteria.from(City.class);

        criteria.select(root);
        criteria.where(builder.equal(root.get("name"), name));

        try {
            return getEntityManager().createQuery(criteria).getSingleResult();
        } catch (Exception ex) {
            //TODO handle exceptions here
            return null;
        }
    }
}
