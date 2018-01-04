import Ember from 'ember';
import RSVP from 'rsvp';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Route.extend({
    restaurantService: service('restaurant-service'),
    administratorService: service('administrator-service'),

    actions: {
        addRestaurant() {
            this.get('administratorService').addRestaurant(this.controller.get('restaurantName'), this.controller.get('restaurantDescription'),
                this.controller.get('selectedCategories'), this.controller.get('selectedLocation'), this.controller.get('marker').getPosition().lng(), this.controller.get('marker').getPosition().lat(), this.controller.get('priceRange'), 
                "/images/restaurant_logo.jpg", "/images/restaurant_cover.jpg")
                .then(data => {
                    let newTableItems = this.controller.get('newTableItems');
                    let tableItems = [];

                    for (let i = 0; i < newTableItems.length; i++) {
                        for (let j = 0; j < newTableItems[i].ammount; j++) {
                            tableItems.push(new Object({
                                sittingPlaces: newTableItems[i].sittingPlaces,
                                restaurantId: data.id
                            }))
                        }
                    }
                    this.get('administratorService').adminTableItems(tableItems, new Array(), new Array())
                        .then(data => {

                        }) 
                        .catch(error => {
                            console.log(error);
                        });
                    let newMenuItems = this.controller.get('newMenuItems');
                    for(let i = 0; i < newMenuItems.length; i++) {
                        newMenuItems[i].idRestaurant = data.id;
                    }
                    this.get('administratorService').adminMenuItems(newMenuItems, new Array(), new Array())
                        .then(data => {
                            window.location.reload(true);
                        })
                        .catch(error => {
                            console.log(error);
                        });
                })
                .catch(error => {
                    console.log(error);
                    alert("Operation failed");
                })
        }
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
                }),
        })

    }
});
