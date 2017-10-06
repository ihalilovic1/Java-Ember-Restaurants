import CustomAjax from './ajax';

export default CustomAjax.extend({
    isLoggedIn: false,
    currentUser: null,
    errorMessage: "",

    getIsLoggedIn() {
        return this.get('isLoggedIn');
    },
    getCurrentUser() {
        return new Promise((resolve, reject) => {
            this.request('/currentUser')
                .then(data => {
                    this.set('currentUser', data);
                    this.set('isLoggedIn', true);
                    resolve(data);
                })
                .catch(error => {
                    this.set('currentUser', null);
                    this.set('isLoggedIn', false);
                    reject(error);
                });
        });
    },
    login(email, password) {
        return new Promise((resolve, reject) => {
            this.post('/login', {
                xhrFields: {
                    withCredentials: true,
                  },
                data: {
                    email: email,
                    password: password
                }
            }).then(data => {
                this.set('currentUser', data);
                this.set('isLoggedIn', true);
                resolve(data);
            })
            .catch(error => {
                this.set('currentUser', null);
                this.set('isLoggedIn', false);
                reject(error);
            })
        })
    }
  
    // Rest of the methods
  });
  