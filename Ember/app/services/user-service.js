import CustomAjax from './ajax';

export default CustomAjax.extend({
    currentUser: null,
    isLoggedIn: false,
    errorMessage: "",

    getCurrentUser() {
        return this.get('/currentUser')
            .then((data) => function(data) {
                this.get('currentUser').set(data);
                this.get('isLoggedin').set(true);
            })
            .catch(function(error) {
                alert("error"); //for debugging
                this.get('errorMessage').set("error occured, proly not logged in"); //fix error handling, use raw request or smtn
            });
    },
    login(email, password) {
        alert(email + " " + password); //for debugging
        return this.post('/login', {
            xhrFields: {
                withCredentials: true,
              },
            data: {
                email: email,
                password: password
            }
        }).then((data) => function(data) {
            alert("works"); //for debugging
            this.get('currentUser').set(data);
            this.get('isLoggedin').set(true);
        }).catch(function(error) {
            alert("error"); //for debugging
            this.get('errorMessage').set("error occured, proly not logged in"); //fix error handling, use raw request or smtn
        });
    }
  
    // Rest of the methods
  });
  