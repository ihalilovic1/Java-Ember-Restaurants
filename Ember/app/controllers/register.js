import Ember from 'ember';

export default Ember.Controller.extend({
    selectedCountry:   null,
    selectedCity:      null,
    loading:    false,
    
    actions:{
        updateCountryValue: function(value) {
            this.set('selectedCountry', value);
        },
        updateCityValue: function(value) {
            this.set('selectedCity', value);
        }
    }
});
