import EmberUploader from 'ember-uploader';
import Ember from 'ember';

export default EmberUploader.FileField.extend({
    filesDidChange: function (files) {
        const uploader = EmberUploader.Uploader.create({
            url: this.get('url')
        });

        if (!Ember.isEmpty(files)) {
            let path = this.get('oldPath');
            uploader.upload(files[0], {
                path: path ? path : '',
                uploadFor: this.get('uploadFor') 
            }).then(data => {
                this.sendAction("returnPath", data.path)
            }, error => {
                console.log(error);
            })
        }

    }
});