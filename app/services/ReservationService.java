package services;

import forms.ReservationForm;
import helpers.AvailableTableResponse;
import models.tables.Reservation;
import models.tables.Restaurant;
import models.tables.RestaurantTable;
import models.tables.User;
import org.joda.time.DateTime;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ReservationService extends AbstractService {

    private static Long ONE_HOUR = TimeUnit.HOURS.toMillis(1);
    private static Long TWO_HOURS = TimeUnit.HOURS.toMillis(2);

    public Reservation makeReservation(ReservationForm reservationForm, User user) {
        //get all tables from wanted restaurant with wanted num of persons
        Restaurant restaurant = new Restaurant();
        restaurant.setId(UUID.fromString(reservationForm.getIdRestaurant()));

        Timestamp reservationTime = new Timestamp(reservationForm.getDateTime().getMillis());

        List<RestaurantTable> restaurantTables = getAllRestaurantTables(restaurant, reservationForm.getPersons())
                                                    .stream()
                                                        .filter(rt -> isTableFree(rt, reservationTime))
                                                        .collect(Collectors.toList());

        if(restaurantTables.isEmpty())
            throw new IllegalArgumentException("Table does not exist");


        Reservation newReservation = new Reservation(restaurantTables.get(0), user, reservationTime,
                                            new Timestamp(DateTime.now().getMillis()), true);
        EntityManager entityManager = getEntityManager();

        entityManager.persist(newReservation);

        entityManager.flush();

        return newReservation;
    }

    public List<RestaurantTable> getAllRestaurantTables(Restaurant restaurant, Integer persons) {
        EntityManager em = getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<RestaurantTable> criteria = cb.createQuery(RestaurantTable.class);

        Root<RestaurantTable> root = criteria.from(RestaurantTable.class);

        criteria.select( root );

        criteria.where(cb.equal(root.get("restaurantId"), restaurant), cb.equal(root.get("persons"), persons));

        return em.createQuery(criteria).getResultList();
    }

    public Boolean isTableFree(RestaurantTable table, Timestamp when) {


        //Table is free 2 hours before reservation time and two hours after reservation time
        Timestamp intervalStart = new Timestamp(when.getTime());
        intervalStart.setTime(when.getTime() - TWO_HOURS);

        Timestamp intervalEnd = new Timestamp(when.getTime());
        intervalEnd.setTime(when.getTime() + TWO_HOURS);

        EntityManager em = getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<RestaurantTable> criteria = cb.createQuery(RestaurantTable.class);

        Root<Reservation> root = criteria.from(Reservation.class);

        criteria.select(root.get("idTable"));

        criteria.where(cb.equal(root.get("idTable"), table), cb.between(root.get("reservationTime"), intervalStart, intervalEnd));

        //TODO use count instead of entity loading

        List<RestaurantTable> restaurantTables = em.createQuery(criteria).getResultList();

        return restaurantTables.isEmpty();
    }

    public AvailableTableResponse checkReservationAvailability(ReservationForm reservationForm, User user) {

        Restaurant restaurant = new Restaurant();
        restaurant.setId(UUID.fromString(reservationForm.getIdRestaurant()));

        List<RestaurantTable> tableList = getAllRestaurantTables(restaurant, reservationForm.getPersons());

        AvailableTableResponse availableTableResponse = new AvailableTableResponse(restaurant);

        return availableTableResponse;
    }

}
