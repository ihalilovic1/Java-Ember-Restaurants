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
                //alert((document.getElementById('country')).options[this.get('controller').countryIndex].text);
                this.get('userService').register(this.get('controller.firstName'), this.get('controller.lastName'), this.get('controller.email'),
                    this.get('controller.phone'), (document.getElementById('country')).options[this.get('controller').countryIndex].text,
                    (document.getElementById('city')).options[this.get('controller').countryIndex].text, this.get('controller.password'))
                    .then(data => {
                        this.transitionTo('index');
                    })
                    .catch(error => {
                        alert("Registration was not successfull");
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
