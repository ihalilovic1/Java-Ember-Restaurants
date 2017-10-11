import Ember from 'ember';

export default Ember.Controller.extend({
    countryIndex:   0,
    cityIndex:      0,
    
    actions:{
        updateCountryValue: function(value) {
            this.set('countryIndex', value);
        },
        updateCityValue: function(value) {
            this.set('cityIndex', value);
        }
    }
});
