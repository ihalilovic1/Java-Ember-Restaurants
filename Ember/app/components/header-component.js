import Ember from 'ember';
    
export default Ember.Component.extend({
    actions: {
        setActive(id) {
            document.getElementById(id).style.color = "rgb(253, 111, 96)";
        }
    }
    
});
