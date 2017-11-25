import Ember from 'ember';
import RSVP from 'rsvp';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Route.extend({

    activate: function () {
        this._super();
        window.scrollTo(0, 0);
    },

    restaurantService:      service('restaurant-service'),
    userService:    service('user-service'),
    reservationService:     service('reservation-service'),

    formatDate: function(date) {
        var monthNames = [
          "Jan", "Feb", "Mar",
          "Apr", "May", "Jun", "Jul",
          "Aug", "Sep", "Oct",
          "Nov", "Dec"
        ];
      
        var day = date.getDate();
        var monthIndex = date.getMonth();
        var year = date.getFullYear();
      
        return monthNames[monthIndex] + ' ' + day + ', ' + year;
    },

    formatTime: function(time) {
        var hours = [
            "12", "01", "02", "03",
            "04", "05", "06", "07",
            "08", "09", "10",
            "11"
          ];

        var array = time.split(":");
      
        var hour = array[0];
        var minute = array[1];
        var a = 'AM';

        if(hour >= 12) {
            a = 'PM';
            hour = hours[hour % 12];
        }
        return hour + ':' + minute + ' ' + a;
    },

    actions: {
        sendReview(currentUser, restaurant) {
            this.get('restaurantService').insertComment(this.get('controller.userRating'), 
                        currentUser.id, restaurant.id, this.get('controller').userComment)
                .then(data => {
                    this.refresh();
                })
                .catch(error => {
                })
        },

        findTable(numberOfPeople, date, time, restaurantId) {
            this.set('controller.findingTable', true);
            var dateString = this.formatDate(new Date(date));
            var timeString = this.formatTime(time);
            this.set('controller.selectedDate', dateString);
            this.set('controller.selectedTime', timeString);
            this.set('controller.selectedPeople', numberOfPeople);

            this.set('controller.foundTables', null);
            this.get('reservationService').checkReservationAvailability(numberOfPeople, dateString, timeString, restaurantId)
                .then(data => {
                    this.set('controller.foundTables', data);
                    this.set('controller.findingTable', false);
                })
                .catch(error => {
                    this.set('controller.foundTables', null);
                    this.set('controller.findingTable', false);
                })
                        
        },

        makeReservation(time, restaurantId) {
            this.get('reservationService').makeReservation(this.get('controller.selectedPeople'), this.get('controller.selectedDate'), time, restaurantId)
                .then(data => {
                    this.transitionTo('complete-reservation', restaurantId, data.id);
                    this.controller.set('foundTables', null);
                })
                .catch(error => {
                    alert(error);
                })
        }
    },

    model(params) {
        return RSVP.hash({
            restaurant:     this.get('restaurantService').getRestaurantDetails(params.restaurant_id)
                                .then(data => {
                                    return data;
                                })              
                                .catch(error => {
                                    return null;
                                }),
            breakfast:          this.get('restaurantService').getRestaurantMenu(params.restaurant_id, "Breakfast")
                                    .then(data => {
                                        return data;
                                    })
                                    .catch(error => {
                                        
                                        return null;
                                    }),
            lunch:          this.get('restaurantService').getRestaurantMenu(params.restaurant_id, "Lunch")
                                    .then(data => {
                                        return data;
                                    })
                                    .catch(error => {
                                        return null;
                                    }),
            dinner:          this.get('restaurantService').getRestaurantMenu(params.restaurant_id, "Dinner")
                                    .then(data => {
                                        return data;
                                    })
                                    .catch(error => {
                                        return null;
                                    }),
            currentUser:    this.get('userService').getCurrentUser()
                                .then(data => {
                                    return data;
                                })
                                .catch(error => {
                                    return null;
                                }),
        })
    }
});
