package services;

import forms.FindTablesForm;
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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ReservationService extends AbstractService {

    private static Long FIFTEEN_MINUTES = TimeUnit.MINUTES.toMillis(15);
    private static Long TWO_HOURS = TimeUnit.HOURS.toMillis(2);
    private static Long FIVE_MINUTES = TimeUnit.MINUTES.toMillis(5);

    public Reservation makeReservation(ReservationForm reservationForm) {

        Restaurant restaurant = new Restaurant();
        restaurant.setId(UUID.fromString(reservationForm.getIdRestaurant()));

        Timestamp reservationTime = new Timestamp(reservationForm.getDateTime().getMillis());

        List<RestaurantTable> restaurantTables = getAllRestaurantTables(restaurant, reservationForm.getPersons())
                                                    .stream()
                                                        .filter(rt -> isTableFree(rt, reservationTime))
                                                        .collect(Collectors.toList());

        if(restaurantTables.isEmpty())
            throw new IllegalArgumentException("Table does not exist");

        Reservation newReservation = new Reservation(restaurantTables.get(0), null, reservationTime,
                                            new Timestamp(DateTime.now().getMillis()), false);
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
        //Table is free it reservation is not confirmed 5 minutes after it is added to db
        Timestamp intervalStart = new Timestamp(when.getTime());
        intervalStart.setTime(when.getTime() - TWO_HOURS);

        Timestamp intervalEnd = new Timestamp(when.getTime());
        intervalEnd.setTime(when.getTime() + TWO_HOURS);

        Timestamp timestampNow = new Timestamp(DateTime.now().getMillis());
        timestampNow.setTime(timestampNow.getTime() - FIVE_MINUTES);

        EntityManager em = getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<RestaurantTable> criteria = cb.createQuery(RestaurantTable.class);

        Root<Reservation> root = criteria.from(Reservation.class);

        criteria.select(root.get("idTable"));

        criteria.where(cb.equal(root.get("idTable"), table), cb.between(root.get("reservationTime"), intervalStart, intervalEnd),
                        cb.or(cb.isTrue(root.get("isConfirmed")), cb.greaterThanOrEqualTo(root.get("timeAdded"), timestampNow)));

        //TODO use count instead of entity loading

        List<RestaurantTable> restaurantTables = em.createQuery(criteria).getResultList();

        return restaurantTables.isEmpty();
    }

    public AvailableTableResponse checkReservationAvailability(ReservationForm reservationForm) {

        Restaurant restaurant = new Restaurant();
        restaurant.setId(UUID.fromString(reservationForm.getIdRestaurant()));

        List<RestaurantTable> tableList = getAllRestaurantTables(restaurant, reservationForm.getPersons());

        List<Timestamp> timestampList = new ArrayList<>();
        Timestamp reservationTime = new Timestamp(reservationForm.getDateTime().getMillis());
        timestampList.add(reservationTime);


        for(int i = 1; i < 7; i++) {
            timestampList.add(new Timestamp(reservationTime.getTime() + i*FIFTEEN_MINUTES));
            timestampList.add(new Timestamp(reservationTime.getTime() - i*FIFTEEN_MINUTES));
        }


        AvailableTableResponse availableTableResponse = new AvailableTableResponse(restaurant);

        for(RestaurantTable table : tableList ) {
            for (Timestamp time : timestampList) {
                if(isTableFree(table, time)) {
                    availableTableResponse.addTime(time);
                    break;
                }
            }
        }

        return availableTableResponse;
    }

    public Reservation getReservation(UUID id) {
        try {
            EntityManager entityManager = getEntityManager();

            return entityManager.find(Reservation.class, id);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Reservation not found");
        }

    }

    public Boolean confirmReservation(UUID id, User user) {
        try {
            Timestamp timestampNow = new Timestamp(DateTime.now().getMillis());
            timestampNow.setTime(timestampNow.getTime() - FIVE_MINUTES);

            Reservation reservation = getReservation(id);
            if(reservation.getConfirmed() || reservation.getTimeAdded().before(timestampNow)) {
                return false;
            } else {
                reservation.setIdUser(user);
                reservation.setConfirmed(true);
                getEntityManager().flush();
                return true;
            }
        } catch (Exception ex) {
            throw ex;
        }

    }

    public List<Restaurant> getFreeTables(FindTablesForm form) {
        return null;
    }

}
