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

    addRestaurant(restaurantName, description, categories, location, longitude, latitude, priceRange, imageFileName, coverFileName) {
        return new Promise((resolve, reject) => {
            this.post('/admin/addRestaurant', {
                data: {
                    restaurantName: restaurantName,
                    description: description,
                    categories: categories,
                    location: location,
                    longitude: longitude,
                    latitude: latitude,
                    priceRange: priceRange,
                    imageFileName,
                    coverFileName
                }
            }).then(data => {
                resolve(data);
            })
            .catch(error => {
                reject(error);
            })
        })
    },

    adminTableItems(addQueue, editQueue, deleteQueue) {
        return new Promise((resolve, reject) => {
            this.post('/admin/adminTableItems', {
                data: {
                    addQueue: addQueue,
                    editQueue: editQueue,
                    deleteQueue: deleteQueue
                }
            }).then(data => {
                resolve(data);
            })
                .catch(error => {
                    reject(error);
                })
        })
    },

    adminMenuItems(addQueue, editQueue, deleteQueue) {
        return new Promise((resolve, reject) => {
            this.post('/admin/adminMenuItems', {
                data: {
                    addQueue: addQueue,
                    editQueue: editQueue,
                    deleteQueue: deleteQueue
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
