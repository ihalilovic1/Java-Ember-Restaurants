import Ember from 'ember';

export function currentDate(params/*, hash*/) {
  return new Date().toISOString().substring(0, 10);
}

export default Ember.Helper.helper(currentDate);
