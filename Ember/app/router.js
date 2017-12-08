import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('login');
  this.route('register');
  this.route('restaurants');
  this.route('restaurant', { path: '/restaurant/:restaurant_id' });
  this.route('complete-reservation', { path: '/complete-reservation/:restaurant_id/:reservation_id' });
  this.route('admin');
});

export default Router;
