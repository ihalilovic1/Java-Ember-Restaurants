import CustomAjax from './ajax';

export default CustomAjax.extend({
    errorMessage: "",
    
    makeReservation(persons, reservationDate, reservationHour, idRestaurant) {
        return new Promise((resolve, reject) => {
            this.post('/makeReservation', {
                xhrFields: {
                    withCredentials: true,
                  },
                  data: {
                    persons: persons,
                    reservationDate: reservationDate,
                    reservationHour: reservationHour,
                    idRestaurant: idRestaurant
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

    checkReservationAvailability(persons, reservationDate, reservationHour, idRestaurant) {
        return new Promise((resolve, reject) => {
            this.post('/checkReservationAvailability', {
                xhrFields: {
                    withCredentials: true,
                  },
                  data: {
                    persons: persons,
                    reservationDate: reservationDate,
                    reservationHour: reservationHour,
                    idRestaurant: idRestaurant
                  }
            }).then(data => {
                    resolve(data);
                })
                .catch(error => {
                    reject(error);
                });
        });
        
    },

    getListOfReservationsForUser() {
        return new Promise((resolve, reject) => {
            this.request('/getListOfReservationsForUser')
                .then(data => {
                    resolve(data);
                })
                .catch(error => {
                    this.set('errorMessage', error);
                    reject(error);
                });
        });
    },

    getReservation(id) {
        return new Promise((resolve, reject) => {
            this.post('/getReservation', {
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
                    reject(error);
                });
        })
    },

    confirmReservation(id) {
        return new Promise((resolve, reject) => {
            this.post('/confirmReservation', {
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
                    reject(error);
                });
        })
    }
    
  });
  