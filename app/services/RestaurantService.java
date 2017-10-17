package services;

import forms.ReviewForm;
import helpers.RestaurantLocationResponse;
import models.tables.*;
import org.hibernate.criterion.Projections;
import org.hibernate.jpa.HibernateEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class RestaurantService extends AbstractService {


    public Restaurant getRestaurantById(UUID uuid) {
        try {
            EntityManager em = getEntityManager();
            return em.find(Restaurant.class, uuid);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public List<Restaurant> getAllRestaurants() {
        try {
            EntityManager em = getEntityManager();

            CriteriaBuilder builder = em.getCriteriaBuilder();

            CriteriaQuery<Restaurant> criteria = builder.createQuery( Restaurant.class );
            Root<Restaurant> root = criteria.from( Restaurant.class );
            criteria.select( root );

            return em.createQuery(criteria).getResultList();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public List<RestaurantLocationResponse> getRestaurantLocations() {

        EntityManager em = getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<RestaurantLocationResponse> criteriaQueryRestaurant = cb.createQuery(RestaurantLocationResponse.class);
        Root<Restaurant> restaurantRoot = criteriaQueryRestaurant.from(Restaurant.class);

        Root<City> cityRoot = criteriaQueryRestaurant.from(City.class);

        Root<Country> countryRoot = criteriaQueryRestaurant.from(Country.class);

        criteriaQueryRestaurant.select(
                cb.construct(
                        RestaurantLocationResponse.class,
                        cityRoot.get("id").alias("id"),
                        cityRoot.get("name").alias("city"),
                        countryRoot.get("name").alias("country"),
                        cb.count(restaurantRoot.get("id"))
                )
        );

        criteriaQueryRestaurant.where(cb.equal(restaurantRoot.get("location"), cityRoot.get("id")),
                cb.equal(cityRoot.get("country"), countryRoot.get("id")));

        criteriaQueryRestaurant.groupBy(cityRoot.get("id"), cityRoot.get("name"), countryRoot.get("name"));

        List<RestaurantLocationResponse> result = em.createQuery(criteriaQueryRestaurant).getResultList();

        return  result;
    }

    public void insertComment(ReviewForm reviewForm) {
        EntityManager em = getEntityManager();

        User userFK = new User();
        userFK.setId(UUID.fromString(reviewForm.getIdUser()));

        Restaurant restaurantFK = new Restaurant();
        restaurantFK.setId(UUID.fromString(reviewForm.getIdRestaurant()));

        Review newReview = new Review(reviewForm.getMark(), userFK, restaurantFK, reviewForm.getComment());

        em.persist(newReview);
    }

    public List<FoodType> getAllCategories() {
        EntityManager em = getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<FoodType> criteria = cb.createQuery(FoodType.class);

        Root<FoodType> root = criteria.from(FoodType.class);

        criteria.select( root );

        return em.createQuery(criteria).getResultList();
    }

}
