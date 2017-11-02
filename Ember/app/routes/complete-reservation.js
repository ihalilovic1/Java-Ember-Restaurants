import Ember from 'ember';
import RSVP from 'rsvp';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Route.extend({
    reservationService:  service('reservation-service'),
    userService:    service('user-service'),
    restaurantService:    service('restaurant-service'),

    model(params) {
        return RSVP.hash({
            reservation:    this.get('reservationService').getReservation(params.reservation_id)
                                .then(data => {
                                    return data;
                                })
                                .catch(error => {
                                    history.back();
                                }),
            restaurant:     this.get('restaurantService').getRestaurantDetails(params.restaurant_id)
                                .then(data => {
                                    return data;
                                })
                                .catch(error => {
                                    history.back();
                                }),
           
            currentUser:    this.get('userService').getCurrentUser()
                                .then(data => {
                                    return data;
                                })
                                .catch(error => {
                                    return null;
                                }),
            
        })
    }
});
