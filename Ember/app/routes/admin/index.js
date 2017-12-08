import Ember from 'ember';
import RSVP from 'rsvp';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Route.extend({
    adminService: service('administrator-service'),

    model() {
        return RSVP.hash({
            counters: this.get('adminService').getCounters()
                .then(data => {
                    return data;
                })
                .catch(error => {
                    return null;
                })
        })
    },

    afterModel(model) {
        this.controllerFor('admin').set('dashRadio', true);
    }
});
