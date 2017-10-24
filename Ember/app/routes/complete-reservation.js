import Ember from 'ember';
import RSVP from 'rsvp';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Route.extend({
    reservationService:  service('reservation-service'),

    model() {
        return RSVP.hash({
            reservation:    null
        })
    }
});
