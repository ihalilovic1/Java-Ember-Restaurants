import Ember from 'ember';

export default Ember.Component.extend({

    numberOfPeople: 2,
    date: "",
    time: "",
    

    actions: {
        findTables() {
            this.sendAction('findTableAction', this.get('numberOfPeople') + ' people', this.get('date'), this.get('time'), this.get('restaurantId'));
        },

        setNumberOfPeople(value) {
            this.set('numberOfPeople', value);
        }
    }
    
});
