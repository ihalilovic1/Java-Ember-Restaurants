import Ember from 'ember';

export function loop(params/*, hash*/) {
  return new Array(params[0]);
}

export default Ember.Helper.helper(loop);
