import Ember from 'ember';

export default Ember.Component.extend({
    oneStar: Ember.computed('rating', function() {
        if(this.get('rating') > 0) {
            return 'highlighted-dollar';
        } else {
            return 'empty-dollar';
        }
    }),

    twoStar: Ember.computed('rating', function() {
        if(this.get('rating') > 1) {
            return 'highlighted-dollar';
        } else {
            return 'empty-dollar';
        }
    }),

    threeStar: Ember.computed('rating', function() {
        if(this.get('rating') > 2) {
            return 'highlighted-dollar';
        } else {
            return 'empty-dollar';
        }
    }),

    fourStar: Ember.computed('rating', function() {
        if(this.get('rating') > 3) {
            return 'highlighted-dollar';
        } else {
            return 'empty-dollar';
        }
    })
});
