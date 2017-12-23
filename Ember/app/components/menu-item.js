import Ember from 'ember';

export default Ember.Component.extend({
    name: '',
    description: '',
    price: null,

    dataChanged: Ember.observer('name', 'description', 'price', function() {
        this.sendAction('dataUpdate',this.get('index') - 1, this.get('name'), this.get('description'), this.get('price'));
    }),


    focusIn() {
        this.sendAction('onfocus', this.get('index') - 1);
    },
    actions: {
        deleteData() {
            this.sendAction('dataDelete', this.get('index') - 1);
        }
    }
});
