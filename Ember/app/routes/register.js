import Ember from 'ember';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Route.extend({
    userService:    service('user-service'),
    
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
        }
});
