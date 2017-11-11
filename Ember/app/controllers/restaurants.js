import Ember from 'ember';

export default Ember.Controller.extend({
    queryParams: [{
        cuisines: 'cuisines',
        priceFilter: 'priceFilter',
        ratingFilter: 'ratingFilter',
        pageNumber: 'pageNumber',
        searchText: 'searchText',
        sortBy: 'sortBy'
    }],

    cuisines: '',
    ratingFilter: 0,
    priceFilter: 0,
    pageNumber: 1,
    searchText: "",
    sortBy: null,
    fontAwesomePlaceHolder: "\uF002 Location, Restaurant or cuisine",

    actions: {
        priceFilter(price) {
            this.set('priceFilter', price);
        },

        ratingFilter(rating) {
            this.set('ratingFilter', rating);
        },

        updatePage(page) {
            page += 1;

            if (page >= this.get('numberOfPages')) {
                page = 1;
            }

            this.set('pageNumber', page);
        },

        sortBy(param) {
            this.set('sortBy', param);
        },

        updateSearchText() {
            this.set('searchText', this.get('textQuery'));
        },

        updateCuisines(cuisine) {
            let cuisines = this.get('cuisines').split('-');
            if(cuisines.includes(cuisine)) {
                cuisines.splice(cuisines.indexOf(cuisine), 1);
            } else {
                cuisines.push(cuisine);
            }
            cuisines = cuisines.join('-');
            while (cuisines.charAt(0) === '-') {
                cuisines = cuisines.substr(1);
            }
            this.set('cuisines', cuisines);
        },     

        isChecked() {
            this.console.log('poziv');
            return true;
        }
    }
});
