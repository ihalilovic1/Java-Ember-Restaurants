import Ember from 'ember';
import RSVP from 'rsvp';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Route.extend({
    restaurantService:      service('restaurant-service'),

    model(params) {
        return RSVP.hash({
            restaurant:     this.get('restaurantService').getRestaurantDetails(params.restaurant_id)
                                .then(data => {
                                    return data;
                                })              
                                .catch(error => {
                                    return null;
                                })
        })
    }
});
