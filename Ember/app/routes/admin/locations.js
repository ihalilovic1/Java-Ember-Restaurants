import Ember from 'ember';

export default Ember.Route.extend({

    afterModel(model) {
        this.controllerFor('admin').set('locRadio', true);
    }
});
