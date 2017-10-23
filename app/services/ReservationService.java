package services;

import forms.ReservationForm;
import models.tables.Reservation;
import models.tables.Restaurant;
import models.tables.RestaurantTable;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.List;

public class ReservationService extends AbstractService {

    public Reservation makeReservation(ReservationForm reservationForm) {
        //get all tables from wanted restaurant with wanted num of persons

        Reservation newReservation = new Reservation();
        return  newReservation;
    }

    public List<RestaurantTable> getAllRestaurantTables(Restaurant restaurant, Integer persons) {
        EntityManager em = getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<RestaurantTable> criteria = cb.createQuery(RestaurantTable.class);

        Root<RestaurantTable> root = criteria.from(RestaurantTable.class);

        criteria.select( root );

        criteria.where(cb.equal(root.get("restaurantid"), restaurant), cb.equal(root.get("persons"), persons));

        return em.createQuery(criteria).getResultList();
    }

    public Boolean isTableReserved(RestaurantTable table, Timestamp when) {
        EntityManager em = getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<RestaurantTable> criteria = cb.createQuery(RestaurantTable.class);

        Root<Reservation> root = criteria.from(Reservation.class);

        criteria.select(root.get("idtable"));

        criteria.where(cb.equal(root.get("idtable"), table), cb.equal(root.get("datetime"), when));



        return true;
    }

}
