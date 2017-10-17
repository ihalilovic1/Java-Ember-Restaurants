import CustomAjax from './ajax';

export default CustomAjax.extend({
    errorMessage: "",

    getRestaurantLocations() {
        return new Promise((resolve, reject) => {
            this.request('/getRestaurantLocations')
                .then(data => {
                    resolve(data);
                })
                .catch(error => {
                    this.set('errorMessage', error);
                    reject(error);
                });
        });
    },
    getRestaurantMenu(id, type) {
        return new Promise((resolve, reject) => {
            this.post('/getRestaurantMenu', {
                xhrFields: {
                    withCredentials: true,
                  },
                data: {
                    id: id,
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
    }
  
    // Rest of the methods
  });
  