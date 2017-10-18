import Ember from 'ember';

export default Ember.Component.extend({
    oneStar: Ember.computed('rating', function() {
        if(this.get('rating') > 0) {
            return 'highlighted-star';
        } else {
            return 'empty-star';
        }
    }),

    twoStar: Ember.computed('rating', function() {
        if(this.get('rating') > 1) {
            return 'highlighted-star';
        } else {
            return 'empty-star';
        }
    }),

    threeStar: Ember.computed('rating', function() {
        if(this.get('rating') > 2) {
            return 'highlighted-star';
        } else {
            return 'empty-star';
        }
    }),

    fourStar: Ember.computed('rating', function() {
        if(this.get('rating') > 3) {
            return 'highlighted-star';
        } else {
            return 'empty-star';
        }
    }),

    fiveStar: Ember.computed('rating', function() {
        if(this.get('rating') > 4) {
            return 'highlighted-star';
        } else {
            return 'empty-star';
        }
    }),
});
