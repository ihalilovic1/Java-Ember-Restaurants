package services;


import forms.LoginForm;
import forms.RegisterForm;
import models.tables.City;
import models.tables.Country;
import models.tables.User;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.UUID;

public class UserService extends AbstractService {

    public User register(RegisterForm registerForm) {

        EntityManager entityManager = getEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Country> countryCriteria = builder.createQuery( Country.class );
        Root<Country> countryRoot = countryCriteria.from( Country.class );
        countryCriteria.select( countryRoot );
        countryCriteria.where( builder.equal( countryRoot.get( "name" ), registerForm.getCountry() ) );

        Country country = entityManager.createQuery( countryCriteria ).getSingleResult();

        CriteriaQuery<City> cityCriteria = builder.createQuery( City.class );
        Root<City> cityRoot = cityCriteria.from( City.class );
        cityCriteria.select( cityRoot );
        cityCriteria.where( builder.equal( cityRoot.get( "name" ), registerForm.getCity() ),
                builder.equal( cityRoot.get( "country" ), country ) );
        System.out.println("JJJJJJJJJJJJJJJJJJJJJJJJJJJ");
        City city = entityManager.createQuery(cityCriteria).getSingleResult();
        System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFF");
        User newUser = new User(registerForm.getFirstName(), registerForm.getLastName(), registerForm.getEmail(), registerForm.getPhone(),
                city, false, registerForm.getPassword());

        entityManager.persist(newUser);

        entityManager.flush();

        return newUser;

    }

    public User login(LoginForm loginForm) {
        EntityManager em = getEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);

        criteria.select(root);
        criteria.where(builder.equal(root.get("password"), loginForm.getPassword()), builder.equal(root.get("email"), loginForm.getEmail()));

        try {
            User result = em.createQuery(criteria).getSingleResult();
            return result;
        } catch (Exception ex) {
            System.out.println(loginForm.getEmail() + " " + loginForm.getPassword());
            //TODO handle exceptions here
            return null;
        }

    }

    public User getUserById(UUID id) {
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

    public User getUserByEmail(String email) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);

        criteria.select(root);
        criteria.where(builder.equal(root.get("email"), email));

        try {
            return getEntityManager().createQuery(criteria).getSingleResult();
        } catch (Exception ex) {
            //TODO handle exceptions here
            return null;
        }
    }
}
