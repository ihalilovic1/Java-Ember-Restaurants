import Ember from 'ember';



export default Ember.Component.extend({
    apikey: 'AIzaSyCMhj68DXGDhPKZEr8wDSBJAzOMvdGaKvg',
    lat: 43.84864,
    lng: 18.35644,
    zoom: 13,
    mapType: 'roadmap', // Accepts 'roadmap', 'satellite', 'hybrid', or 'terrain'
    showMapTypeControl: true,
    clickableIcons: true,
    draggable: true,
    disableDefaultUI: false,
    disableDoubleClickZoom: false,
    scrollwheel: true,
    showZoomControl: true,
    showScaleControl: true,


    markers: null,

    didReceiveAttrs() {
        this._super(...arguments);

        if(!this.get('isAdmin')) {
            this.set('markers', [
            {
                id: this.get('restaurant').location,  
                lat: this.get('restaurant').latitude, 
                lng: this.get('restaurant').longitude, 
                infoWindow: {
                    content: '<p>' + this.get('restaurant').restaurantName +'</p>',
                    visible: true
                },
            }
            ]);
        } else {
            
            this.set('markers', [
                this.get('marker')
            ]);
        }
        
    },
});
