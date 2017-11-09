import Ember from 'ember';

export default Ember.Controller.extend({
    queryParams: {
        cuisines: 'cuisines',
        priceFilter: 'priceFilter',
        ratingFilter: 'ratingFilter',
        pageNumber: 'pageNumber'
    },

    cuisines: [],
    ratingFilter: 0,
    priceFilter: 0,
    pageNumber: 1,

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
        }

    }
});
