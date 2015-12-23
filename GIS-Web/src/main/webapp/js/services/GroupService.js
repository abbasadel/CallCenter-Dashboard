'use strict';

myApp.factory('GroupService', function($http) {

    var group ={};

    return {
        // get all the comments
        get: function() {
            return $http.get('/groups');
        },
        // save a comment (pass in comment data)
        save: function(group) {
//            console.log(group.name);
            return $http({
                method: 'POST',
                data: JSON.stringify(group),
                url: 'groups',
                headers: {'Content-Type': 'application/json'}
            });
        },
        update: function(group){
            return $http({
               method: 'POST',
                data: JSON.stringify({name:group.name,id:group.id}),
                url:'groups/'+group.id,
                headers:{'Content-Type':'application/json'}
            });
        },
        delete: function(group){
              return $http({
                method:'DELETE',
                  url:'groups/'+group.id,
                  headers:{'Content-Type':'application/json'}
              });
        },
        // destroy a comment
        destroy: function(id) {
            return $http.delete('/api/comments/' + id);
        }
    }

});
	