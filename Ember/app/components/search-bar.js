import Ember from 'ember';

export default Ember.Component.extend({

    numberOfPeople: 2,
    date: "",
    time: "",
    
    actions: {
        findTables() {
            if(this.get('textSearch')) {
                this.sendAction('findTableAction', this.get('numberOfPeople') + ' people', this.get('date'), this.get('time'), this.get('textSearch'));
            } else if(this.get('restaurantId')){
                this.sendAction('findTableAction', this.get('numberOfPeople') + ' people', this.get('date'), this.get('time'), this.get('restaurantId'));
            } else {
                this.sendAction('findTableAction', this.get('numberOfPeople') + ' people', this.get('date'), this.get('time'));
            }
        },

        setNumberOfPeople(value) {
            this.set('numberOfPeople', value);
        }
    }
    
});
