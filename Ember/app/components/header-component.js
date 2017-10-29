import Ember from 'ember';
    
const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Component.extend({
    userService:    service('user-service'),
    user: false,

    currentUser: Ember.computed('user', function(){
        return this.get('user');
    }),

    actions: {
        setActive(id) {
            document.getElementById(id).style.color = "rgb(253, 111, 96)";
        },

        logOut() {
            this.get('userService').logout()
                                    .then(data => {
                                        this.set('user', false);
                                    });
        }
    },

    
    
});
