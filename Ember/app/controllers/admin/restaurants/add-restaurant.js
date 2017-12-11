import Ember from 'ember';

export default Ember.Controller.extend({
    selectedCategories: [],
    selectedLocation: '',
    isBreakfast: false,
    isLunch: false,
    isDinner: false,
    numberOfNewMenuItems: 0,
    newMenuItems: [],

    actions: {
        selectLocation(value) {
            this.set('selectedLocation', value);
        },

        selectCuisine(sel) {
            var opts = [],
                opt;
            var len = sel.options.length;
            for (var i = 0; i < len; i++) {
                opt = sel.options[i];

                if (opt.selected) {
                    opts.push(opt.value);
                }
            }

            this.set('selectedCategories', opts);
        },

        newMenuItem() {
            var radios = document.getElementsByName('mealType');

            this.set('numberOfNewMenuItems', this.get('numberOfNewMenuItems') + 1);
            let menuItems = this.get('newMenuItems');

            for (var i = 0, length = radios.length; i < length; i++) {
                if (radios[i].checked) {
                    
                    menuItems.push(new Object({
                        name: '',
                        description: '',
                        price: 0,
                        type: radios[i].value,
                        idRestaurant: '',
                        id: ''
                    }));
                    
                    break;
                }
            }
            console.log(menuItems);

            this.set('newMenuItems', menuItems);
        },

        addRestaurant() {
            console.log(this.get('selectedLocation'));
            console.log(this.get('selectedCategories'));
        }
    }

});
