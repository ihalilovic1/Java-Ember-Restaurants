import Ember from 'ember';

export default Ember.Controller.extend({

    cuisines: [],
    rating:     null,

    restaurantsList: Ember.computed('cuisines', 'rating', function() {
        alert("Updating list");
    })
});
