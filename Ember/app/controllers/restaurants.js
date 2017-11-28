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
    searchText: '',
    sortBy: 'default',
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
            
            if (page > this.get('model.numberOfPages').length) {
                page = 1;
            }

            this.set('pageNumber', page);
            window.scrollTo(0, 0);
        },

        nextPage() { 
            if (this.get('pageNumber') < this.get('model.numberOfPages').length) {
                this.send('updatePage', this.get('pageNumber'));
            }  
        },

        previousPage() {
            if (this.get('pageNumber') > 1) {
                this.send('updatePage', this.get('pageNumber') - 2);
            }  
        },

        sortBy(param) {
            this.set('sortBy', param);
        },

        updateSearchText() {
            let txt = this.get('textQuery');
            if(!txt)
                txt = '';
            this.set('searchText', txt);
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

        seeIfChecked(cuisineName) {
            alert(cuisineName);
            if(this.get('cuisines').includes(cuisineName)) {
                this.set('isChecked', true);
            } else {
                this.set('isChecked', false);
            }
           
        }
    }
});
