import Ember from 'ember';

export function formatTime(params/*, hash*/) {
  var hours = [
    "12", "01", "02", "03",
    "04", "05", "06", "07",
    "08", "09", "10",
    "11"
  ];

  var date = new Date(params[0]);

var hour = date.getHours();
var minute = date.getMinutes();
var a = 'AM';

minute = minute < 10 ? '0' + minute : minute;

if(hour >= 12) {
    a = 'PM';
    hour = hours[hour % 12];
}
return hour + ':' + minute + ' ' + a;
}

export default Ember.Helper.helper(formatTime);
