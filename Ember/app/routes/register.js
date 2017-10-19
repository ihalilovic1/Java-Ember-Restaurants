import Ember from 'ember';
import RSVP from 'rsvp';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Route.extend({
    userService:    service('user-service'),
    restaurantService:  service('restaurant-service'),
    
        actions: {
            register() {
                //(document.getElementById('city')).options[0].text
                let selectedCountry = this.get('controller').selectedCountry ? 
                                        this.get('controller').selectedCountry : 
                                        (document.getElementById('country')).options[0].text;
                let selectedCity = this.get('controller').selectedCity ? 
                                    this.get('controller').selectedCity : 
                                    (document.getElementById('city')).options[0].text;

                this.get('userService').register(this.get('controller.firstName'), this.get('controller.lastName'), this.get('controller.email'),
                this.get('controller.phone'), selectedCountry, selectedCity, this.get('controller.password'))
                .then(data => {
                    this.transitionTo('index');
                })
                .catch(error => {
                    alert("Registration was not successful");
                })   
            }
        },

        model() {
            return RSVP.hash({
                locations:    this.get('restaurantService').getRestaurantLocations()
                                    .then(data => {
                                        return data;
                                    })
                                    .catch(error => {
                                        return null;
                                    })               
            })
            
        }
});
