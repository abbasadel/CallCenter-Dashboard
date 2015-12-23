'use strict';

myApp.factory('StatusService', function($http) {

    return {
        // get all the comments
        get: function(groupId) {
            return $http.get('/status/group/' + groupId);
        },
        // save a comment (pass in comment data)
        save: function(commentData) {
            return $http({
                method: 'POST',
                url: '/api/comments',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: $.param(commentData)
            });
        },
        // destroy a comment
        destroy: function(id) {
            return $http.delete('/api/comments/' + id);
        }
    };

});
	