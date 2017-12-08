import Ember from 'ember';
import RSVP from 'rsvp';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Route.extend({
    userService:    service('user-service'),

    model() {
        return RSVP.hash({
            currentUser:    this.get('userService').getCurrentUser()
                                .then(data => {
                                    return data;
                                })
                                .catch(error => {
                                    return null;
                                })
        })  
    },

    afterModel(model) {
        if (!model.currentUser.admin) {
          this.transitionTo('index');
        }
      }
});
