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

    actions: {
        completeReservation(id) {
            this.get('reservationService').confirmReservation(id)
                .then(data => {
                    if(data) {
                        alert("Reservation confirmed");
                        this.transitionTo("index");
                    } else {
                        alert("Reservation was not successful");
                        history.back();
                    }
                })
                .catch(error => {
                    alert("Reservation was not successful");
                    alert(error);
                    history.back();
                });
        }   
    },

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
