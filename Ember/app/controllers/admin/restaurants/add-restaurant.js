import Ember from 'ember';

export default Ember.Controller.extend({
    selectedCategories: [],
    selectedLocation: '',
    isBreakfast: false,
    isLunch: false,
    isDinner: false,
    numberOfNewMenuItems: 0,
    newMenuItems: [],
    numberOfNewTableItems: 0,
    newTableItems: [],
    logoPath: null,
    coverPath: null,

    actions: {
        setLogoPath(path) {
            this.set('logoPath', path);
        },

        setCoverPath(path) {
            this.set('coverPath', path);
        },

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
                    }));
                    
                    break;
                }
            }

            this.set('newMenuItems', menuItems);
        },

        editMenuItem(index, name, description, price) {
            let menuItems = this.get('newMenuItems');
            menuItems[index].name = name;
            menuItems[index].price = price;
            menuItems[index].description = description;

            this.set('newMenuItems', menuItems);
        },

        deleteMenuItem(index) {
            let menuItems = this.get('newMenuItems');
            menuItems.splice(index, 1);
            this.set('newMenuItems', menuItems);
            this.set('numberOfNewMenuItems', this.get('numberOfNewMenuItems') - 1);
        },

        newTableItem() {
            let tableItems = this.get('newTableItems');

            tableItems.push(new Object({
                sittingPlaces: 2,
                ammount: 0,
            }));
            this.set('numberOfNewTableItems', this.get('numberOfNewTableItems') + 1);
            this.set('newTableItems', tableItems);
        },

        editTableItem(index, numberOfPeople, ammount) {
            let tableItems = this.get('newTableItems');

            tableItems[index].sittingPlaces = numberOfPeople;
            tableItems[index].ammount = ammount;

            this.set('newTableItems', tableItems);
        },

        gotFocus(index) {
            var radios = document.getElementsByName('mealType');

            let menuItems = this.get('newMenuItems');

            for (var i = 0, length = radios.length; i < length; i++) {
                if (menuItems[index].type === radios[i].value) {
                    radios[i].checked = true;
                } else {

                    radios[i].checked = false;
                }
            }

        }
    }

});
