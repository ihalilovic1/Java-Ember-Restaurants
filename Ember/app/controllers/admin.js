import Ember from 'ember';

export default Ember.Controller.extend({
    dashRadio: false,
    restRadio: false,
    locRadio: false,
    catRadio: false,
    userRadio: false,

    actions: {
        menuSelect(goTo) {
            this.set('dashRadio', false);
            this.set('restRadio', false);
            this.set('locRadio', false);
            this.set('catRadio', false);
            this.set('userRadio', false);

            this.transitionToRoute('admin.' + goTo);
        }
    }
});
