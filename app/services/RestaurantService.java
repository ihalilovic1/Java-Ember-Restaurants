package services;

import forms.RestaurantFilterForm;
import forms.ReviewForm;
import helpers.RestaurantLocationResponse;
import helpers.UtilityClass;
import jdk.nashorn.internal.runtime.regexp.joni.constants.EncloseType;
import models.tables.*;
import org.hibernate.jpa.criteria.expression.ParameterExpressionImpl;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.*;
import java.util.stream.Collector;
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

        criteriaQueryRestaurant.orderBy(cb.desc(cb.count(restaurantRoot.get("id"))));

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

        em.flush();
    }

    public List<FoodType> getAllCategories() {
        EntityManager em = getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<FoodType> criteria = cb.createQuery(FoodType.class);

        Root<FoodType> root = criteria.from(FoodType.class);

        criteria.select( root );

        return em.createQuery(criteria).getResultList();
    }

    public void updateRestaurantRating(UUID uuid) {
        EntityManager entityManager = getEntityManager();

        Restaurant restaurant = entityManager.find(Restaurant.class, uuid);

        restaurant.setRating(UtilityClass.getMark(restaurant));

        entityManager.flush();

    }

    public List<Restaurant> getRestauranByFilter(RestaurantFilterForm filterForm) {
        try {
            Integer itemsPerPage = filterForm.getItemsPerPage();
            Integer pageNumber = filterForm.getPageNumber();
            Double priceRange = filterForm.getPriceRange();
            Double rating = filterForm.getRating();
            List<String> foodTypes = filterForm.getCuisines();
            String restaurantName = '%' + filterForm.getSearchText().toLowerCase() + '%';
            String sortBy = filterForm.getSortBy();

            EntityManager entityManager = getEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            CriteriaQuery<Restaurant> criteria = criteriaBuilder.createQuery(Restaurant.class);

            Root<Restaurant> root = criteria.from(Restaurant.class);

            criteria.select( root );

            if(!sortBy.equals("default"))
                criteria.orderBy(criteriaBuilder.asc(root.get(sortBy)));

            criteria.where(criteriaBuilder.lessThanOrEqualTo(root.get("priceRange"), priceRange),
                    criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("name")), restaurantName),
                    criteriaBuilder.greaterThanOrEqualTo(root.get("rating"), rating));

            if(itemsPerPage <= 0) {
                return entityManager.createQuery(criteria)
                        .setFirstResult((pageNumber-1) * itemsPerPage).getResultList();
            } else {
                return entityManager.createQuery(criteria)
                        .setFirstResult((pageNumber-1) * itemsPerPage)
                        .setMaxResults(itemsPerPage).getResultList();
            }

        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw ex;
        }
    }

}
