import Ember from 'ember';

export default Ember.Component.extend({

    numberOfPeople: 2,
    date: new Date().toISOString().substring(0, 10),
    time: "20:00:00",
    fontAwesomePlaceHolder: "\uF002 Location, Restaurant or cuisine",
    
    actions: {
        findTables() {
            if(this.get('textSearch')) {
                this.sendAction('findTableAction', this.get('numberOfPeople') + ' people', this.get('date'), this.get('time'), this.get('query'));
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
