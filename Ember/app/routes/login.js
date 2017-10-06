import Ember from 'ember';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Route.extend({
    userService:    service('user-service'),
    actions: {
        login() {
            this.get('userService').login(this.get('controller.email'), this.get('controller.password'))
                .then(data => {
                    this.transitionTo('index');
                })
                .catch(error => {
                    alert("Login was not successfull");
                })
        }
    }
});
