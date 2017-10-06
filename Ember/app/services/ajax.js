import AjaxService from 'ember-ajax/services/ajax';

export default AjaxService.extend({
  namespace: '/api/v1',
  //host: 'http://localhost:9000', //Setting custom host instead of serving like "ember s --proxy http://localhost:9000"
  contentType: 'application/json; charset=utf-8',
  crossDomain: true
  //contentType: 'application/x-www-form-urlencoded; charset=utf-8'
});