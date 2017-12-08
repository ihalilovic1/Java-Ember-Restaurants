import Ember from 'ember';

export function contains(params/*, hash*/) {
  if (params[0].includes(params[1])) {
    return true;
  } else {
      return false;
  }
}

export default Ember.Helper.helper(contains);
