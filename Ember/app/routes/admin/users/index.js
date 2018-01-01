import Ember from 'ember';
import RSVP from 'rsvp';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Route.extend({
    adminService: service('administrator-service'),

    queryParams: {
        pageNumber: {
            refreshModel: true
        },

        searchText: {
            refreshModel: true
        }
    },

    model(params) {
        return RSVP.hash({
            filteredUsers: this.get('adminService').getFilteredUsers(10, params.pageNumber, params.searchText)
                .then(data => {
                    return data;
                })
                .catch(error => {
                    return null;
                }),

        })
    },
});