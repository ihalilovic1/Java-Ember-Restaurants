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
                                }),
            breakfast:          this.get('restaurantService').getRestaurantMenu(params.restaurant_id, "Breakfast")
                                    .then(data => {
                                        return data;
                                    })
                                    .catch(error => {
                                        
                                        return null;
                                    }),
            lunch:          this.get('restaurantService').getRestaurantMenu(params.restaurant_id, "Lunch")
                                    .then(data => {
                                        return data;
                                    })
                                    .catch(error => {
                                        return null;
                                    }),
            dinner:          this.get('restaurantService').getRestaurantMenu(params.restaurant_id, "Dinner")
                                    .then(data => {
                                        return data;
                                    })
                                    .catch(error => {
                                        return null;
                                    }),
        })
    }
});
