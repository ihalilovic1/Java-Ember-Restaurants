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
    },
});
