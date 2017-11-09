import Ember from 'ember';

export default Ember.Controller.extend({
    queryParams: {
        cuisines: 'cuisines',
        priceFilter: 'priceFilter',
        ratingFilter: 'ratingFilter',
        pageNumber: 'pageNumber'
    },

    cuisines: [],
    ratingFilter: null,
    priceFilter: null,
    pageNumber: 1,

    actions: {
        priceFilter(price) {
            this.set('priceFilter', price);
        },

        ratingFilter(rating) {
            this.set('ratingFilter', rating);
        },

        updatePage(page) {
            alert(page);
        }

    }
});
