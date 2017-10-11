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
                    this.set('controller.loginErrors', false);
                    this.transitionTo('index');
                })
                .catch((error) => {
                    alert("Login was not successfull");
                    this.set('controller.loginErrors', true);
                    this.set('controller.errorMessage', error);
                })
        }
    }
});
