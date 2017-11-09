import Ember from 'ember';
import RSVP from 'rsvp';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Route.extend({
    userService:    service('user-service'),
    restaurantService:      service('restaurant-service'),

    actions: {
        priceFilter(price) {
            alert(price);
        },

        ratingFilter(rating) {
            alert(rating);
        }
    },
    
    model() {
        return RSVP.hash({
            currentUser:    this.get('userService').getCurrentUser()
                                .then(data => {
                                    return data;
                                })
                                .catch(error => {
                                    return null;
                                }),
            
            popularLocations:       this.get('restaurantService').getRestaurantLocations()
                                        .then(data => {
                                            return data;
                                        })              
                                        .catch(error => {
                                            return null;
                                        })

        })
    }
});
