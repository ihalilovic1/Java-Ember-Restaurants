import Ember from 'ember';

export default Ember.Controller.extend({
    queryParams: [{
        reservation: 'reservation',
        restaurant: 'restaurant'
    }],

    reservation: '',
    restaurant: '',
    loginErrors:    false,
    errorMessage:   "Login error",
    loading:    false

});
