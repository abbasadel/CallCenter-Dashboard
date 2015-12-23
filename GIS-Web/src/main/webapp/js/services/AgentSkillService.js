'use strict';

myApp.factory('AgentSkillService', function($http) {

    return {
        // get all the skillsList
        get: function() {
            return $http.get('/skills');
        }
    }

});
	