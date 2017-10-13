package services;

import models.tables.FoodType;
import models.tables.Restaurant;
import models.tables.Review;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;

public class RestaurantService extends AbstractService {


    public Restaurant getRestaurantById(UUID uuid) {
        try {
            EntityManager em = getEntityManager();
            return em.find(Restaurant.class, uuid);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public List<Review> getRestaurantReviews(Restaurant restaurant) {
        try {
            EntityManager em = getEntityManager();

            CriteriaBuilder builder = em.getCriteriaBuilder();

            CriteriaQuery<Review> reviewCriteria = builder.createQuery( Review.class );
            Root<Review> reviewRoot = reviewCriteria.from( Review.class );
            reviewCriteria.select( reviewRoot );
            reviewCriteria.where( builder.equal( reviewRoot.get( "restaurant" ), restaurant ) );

            return em.createQuery( reviewCriteria ).getResultList();
        } catch (Exception ex) {
            throw ex;
        }
    }



}
