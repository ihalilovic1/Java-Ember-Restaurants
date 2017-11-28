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

    queryParams: {
        ratingFilter: {
            refreshModel: true
        },

        priceFilter: {
            refreshModel: true
        },

        pageNumber: {
            refreshModel: true
        },

        cuisines: {
            refreshModel: true
        },

        searchText: {
            refreshModel: true
        },

        sortBy: {
            refreshModel: true
        }
    },
    

    updateRestaurants: function() {
        var searchText = 'price: ' + this.get('priceFilter') + ' ';
        searchText += 'rating: ' + this.get('ratingFilter');
        this.get('restaurantService').getRestaurantsByFilter(1, 6, searchText)
            .then(data => {
                this.controller.set('restaurantsList', data);
            })
            .catch(error => {
                this.controller.set('restaurantsList', null);
            })
    },

    model(params) {
        return RSVP.hash({
            currentUser:    this.get('userService').getCurrentUser()
                                .then(data => {
                                    return data;
                                })
                                .catch(error => {
                                    return null;
                                }),
            
            popularLocations:   this.get('restaurantService').getRestaurantLocations()
                                    .then(data => {
                                        return data;
                                    })              
                                    .catch(error => {
                                        return null;
                                    }),

            restaurantsList:    this.get('restaurantService').getRestaurantsByFilter(params.pageNumber, 6, 
                params.priceFilter, params.ratingFilter, params.cuisines.length != 0? params.cuisines.split('-') : new Array(),
                                    params.searchText, params.sortBy)
                                    .then(data => {
                                        return data;
                                    })
                                    .catch(error => {
                                        return null;
                                    }),

            numberOfPages:      this.get('restaurantService').getNumberOfRestaurants()
                                    .then(data => {
                                        return new Array(Math.ceil(data/6));
                                    })
                                    .catch(error => {
                                        return 0;
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
