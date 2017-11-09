import Ember from 'ember';

export default Ember.Component.extend({
    one: false,
    two: false,
    three: false,
    four: false,
    five: false,

    userRating: Ember.computed('one', 'two', 'three', 'four', 'five', function () {
        if (this.get('five')) {
            return 5;
        } else if (this.get('four')) {
            return 4;
        } else if (this.get('three')) {
            return 3;
        } else if (this.get('two')) {
            return 2;
        } else if (this.get('one')) {
            return 1;
        } else {
            return 0;
        }
    }),

    starOne: Ember.computed('one', function () {
        if (this.get('one')) {
            return "highlighted-star";
        } else {
            return "empty-star";
        }
    }),

    starTwo: Ember.computed('two', function () {
        if (this.get('two')) {
            return "highlighted-star";
        } else {
            return "empty-star";
        }
    }),

    starThree: Ember.computed('three', function () {
        if (this.get('three')) {
            return "highlighted-star";
        } else {
            return "empty-star";
        }
    }),

    starFour: Ember.computed('four', function () {
        if (this.get('four')) {
            return "highlighted-star";
        } else {
            return "empty-star";
        }
    }),

    starFive: Ember.computed('five', function () {
        if (this.get('five')) {
            return "highlighted-star";
        } else {
            return "empty-star";
        }
    }),

    eventHandler() {
        this.sendAction("updateRating", this.get('userRating'));
    },

    actions: {

        oneStar() {
            if(this.get('one')) {
                this.set('one', false);
                this.set('two', false);
                this.set('three', false);
                this.set('four', false);
                this.set('five', false);
            } else {
                this.set('one', true);
                this.set('two', false);
                this.set('three', false);
                this.set('four', false);
                this.set('five', false);
            }
            this.eventHandler();
        },

        twoStar() {
            this.set('one', true);
            this.set('two', true);
            this.set('three', false);
            this.set('four', false);
            this.set('five', false);

            this.eventHandler();
        },

        threeStar() {
            this.set('one', true);
            this.set('two', true);
            this.set('three', true);
            this.set('four', false);
            this.set('five', false);

            this.eventHandler();
        },

        fourStar() {
            this.set('one', true);
            this.set('two', true);
            this.set('three', true);
            this.set('four', true);
            this.set('five', false);

            this.eventHandler();
        },

        fiveStar() {
            this.set('one', true);
            this.set('two', true);
            this.set('three', true);
            this.set('four', true);
            this.set('five', true);

            this.eventHandler();
        }
    }
});
