import Ember from 'ember';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Route.extend({
    userService:    service('user-service'),
    isLoggedIn:     function() {
        return this.get('userService').get('isLoggedIn');
    },
    model() {
        currentUser:    this.get('userService.currentUser');
    },
    actions: {
        getCurrentUser() {
            
        }
    }
});
