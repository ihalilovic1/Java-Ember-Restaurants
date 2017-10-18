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
    
    model() {
        return RSVP.hash({
            currentUser:    this.get('userService').getCurrentUser()
                                .then(data => {
                                    return data;
                                })
                                .catch(error => {
                                    return null;
                                }),
            popularRestaurants:     this.get('restaurantService').getPopularRestaurantsToday()
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
                                        }),
            numberOfRestaurants:     this.get('restaurantService').getNumberOfRestaurants()
        })
        
    }
});
