import CustomAjax from './ajax';

export default CustomAjax.extend({

    getCounters() {
        return new Promise((resolve, reject) => {
            this.request('/admin/getAdministrationCounters')
                .then(data => {
                    resolve(data);
                })
                .catch(error => {
                    reject(error);
                });
        });
    },

    getFilteredRestaurants(itemsPerPage, pageNumber, searchText) {
        return new Promise((resolve, reject) => {
            this.post('/admin/getFilteredRestaurants', {
                xhrFields: {
                    withCredentials: true,
                },
                data: {
                    itemsPerPage: itemsPerPage,
                    pageNumber: pageNumber,
                    searchText: searchText
                }
            }).then(data => {
                resolve(data);
            })
                .catch(error => {
                    reject(error);
                })
        })
    },

    getFilteredCategories(itemsPerPage, pageNumber, searchText) {
        return new Promise((resolve, reject) => {
            this.post('/admin/getFilteredCategories', {
                xhrFields: {
                    withCredentials: true,
                },
                data: {
                    itemsPerPage: itemsPerPage,
                    pageNumber: pageNumber,
                    searchText: searchText
                }
            }).then(data => {
                resolve(data);
            })
                .catch(error => {
                    reject(error);
                })
        })
    },

});
