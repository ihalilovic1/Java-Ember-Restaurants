import Ember from 'ember';
import RSVP from 'rsvp';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Route.extend({
    reservationService:  service('reservation-service'),
    userService:    service('user-service'),

    model() {
        return RSVP.hash({
            reservation:    null,
            currentUser:    this.get('userService').getCurrentUser()
            .then(data => {
                return data;
            })
            .catch(error => {
                return null;
            })
        })
    }
});
