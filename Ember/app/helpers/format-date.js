import Ember from 'ember';

export function formatDate(params/*, hash*/) {
  alert('formating');
  var monthNames = [
    "Jan", "Feb", "Mar",
    "Apr", "May", "Jun", "Jul",
    "Aug", "Sep", "Oct",
    "Nov", "Dec"
  ];

  var day = params[0].getDate();
  var monthIndex = params[0].getMonth();
  var year = params[0].getFullYear();

  return monthNames[monthIndex] + ' ' + day + ', ' + year;
}

export default Ember.Helper.helper(formatDate);
