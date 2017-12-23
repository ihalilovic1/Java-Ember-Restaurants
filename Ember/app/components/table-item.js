import Ember from 'ember';

export default Ember.Component.extend({
    numberOfPeople: "2",
    ammount: null,

    dataChanged: Ember.observer('numberOfPeople', 'ammount', function () {
        this.sendAction('dataUpdate', this.get('index') - 1, this.get('numberOfPeople'), this.get('ammount'));

    }),

    actions: {
        setNumberOfPeople(value) {
            this.set('numberOfPeople', value);
        }
    }
});
