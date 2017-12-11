import Ember from 'ember';
import RSVP from 'rsvp';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Route.extend({
    restaurantService: service('restaurant-service'),

    actions: {

    },

    model() {
        return RSVP.hash({
            locations: this.get('restaurantService').getRestaurantLocations()
                .then(data => {
                    return data;
                })
                .catch(error => {
                    return null;
                }),
                
            restaurantCategories: this.get('restaurantService').getRestaurantCategories()
                .then(data => {
                    return data;
                })
                .catch(() => {
                    return null;
                })
        })

    }
});
