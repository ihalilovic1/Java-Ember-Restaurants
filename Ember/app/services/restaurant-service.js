import CustomAjax from './ajax';

export default CustomAjax.extend({
    errorMessage: "",
    
    insertComment(mark, idUser, idRestaurant, comment) {
        return new Promise((resolve, reject) => {
            this.post('/insertComment', {
                xhrFields: {
                    withCredentials: true,
                  },
                  data: {
                    mark: mark,
                    idUser: idUser,
                    idRestaurant: idRestaurant,
                    comment: comment
                  }
            }).then(data => {
                resolve(data);
            })
            .catch(error => {
                this.set('errorMessage', error);
                reject(error);
            })
        })
    },

    getNumberOfRestaurants() {
        return new Promise((resolve, reject) => {
            this.request('/allRestaurantsSortReservationsToday')
                .then(data => {
                    resolve(data.length);
                })
                .catch(error => {
                    reject(error);
                });
        });
        
    },

    getRestaurantLocations() {
        return new Promise((resolve, reject) => {
            this.request('/getRestaurantsLocations')
                .then(data => {
                    resolve(data);
                })
                .catch(error => {
                    this.set('errorMessage', error);
                    reject(error);
                });
        });
    },
    
    getRestaurantDetails(id) {
        return new Promise((resolve, reject) => {
            this.post('/getRestaurantDetails', {
                xhrFields: {
                    withCredentials: true,
                  },
                  data: {
                      id: id
                  }
            }).then(data => {
                resolve(data);
            })
            .catch(error => {
                this.set('errorMessage', error);
                reject(error);
            })
        })
    },

    getPopularRestaurantsToday() {
        return new Promise((resolve, reject) => {
            this.request('/allRestaurantsSortReservationsToday')
                .then(data => {
                    resolve(data.slice(0,6));
                })
                .catch(error => {
                    reject(error);
                })
        })
    },

    getRestaurantMenu(idRestaurant, type) {
        return new Promise((resolve, reject) => {
            this.post('/getRestaurantMenu', {
                xhrFields: {
                    withCredentials: true,
                  },
                  data: {
                    idRestaurant: idRestaurant,
                    type: type
                  }
            }).then(data => {
                resolve(data);
            })
            .catch(error => {
                this.set('errorMessage', error);
                reject(error);
            })
        })
    }
    
  
    // Rest of the methods
  });
  