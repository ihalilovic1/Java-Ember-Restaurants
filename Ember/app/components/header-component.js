import Ember from 'ember';
    
const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Component.extend({
    userService:    service('user-service'),
    user: null,
    
    currentUser: Ember.computed('user', function(){
        return this.get('user');
    }),

    actions: {
        logOut() {
            this.get('userService').logout()
                                    .then(data => {
                                        this.refresh();
                                        this.set('user', null);
                                    });
        }
    },

    
    
});
