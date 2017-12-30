import Ember from 'ember';

export default Ember.Controller.extend({
    queryParams: [{
        pageNumber: 'pageNumber',
        searchText: 'searchText'
    }],

    pageNumber: 1,
    searchText: '',

    actions: {
        updatePage(page) {
            page += 1;

            if (page > this.get('model.filteredUsers.numberOfPages')) {
                page = 1;
            }

            this.set('pageNumber', page);
            window.scrollTo(0, 0);
        },

        nextPage() {
            if (this.get('pageNumber') < this.get('model.filteredUsers.numberOfPages')) {
                this.send('updatePage', this.get('pageNumber'));
            }
        },

        previousPage() {
            if (this.get('pageNumber') > 1) {
                this.send('updatePage', this.get('pageNumber') - 2);
            }
        },
    }
});
