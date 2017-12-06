import Ember from 'ember';

export default Ember.Component.extend({

    selectedCuisines: [],

    actions: {
        updateCuisines(cuisine) {
            let cuisines = this.get('selectedCuisines');
            if (cuisines.includes(cuisine)) {
                cuisines.splice(cuisines.indexOf(cuisine), 1);
            } else {
                cuisines.push(cuisine);
            }

            this.set('selectedCuisines', cuisines);
            this.sendAction("update", cuisine);
        }
    }
});
