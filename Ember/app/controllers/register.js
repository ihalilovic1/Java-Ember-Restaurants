import Ember from 'ember';

export default Ember.Controller.extend({
    actions: {
        register() {
            alert(this.get('firstName'));
        }
    }
});