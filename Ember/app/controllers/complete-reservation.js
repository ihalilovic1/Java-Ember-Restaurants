import Ember from 'ember';
import { computed } from '@ember/object';

export default Ember.Controller.extend({
    start: new Date().getTime(),
    goal: new Date().getTime() + 5 * 60000,
    isValid: true,

});
