'use strict';

myApp.factory('AuthenticationService', function($http, $rootScope) {

    var users = [
        {name: "ahmed",
            pass: "ahmed123"
        }, {
            name: "admin",
            pass: "admin123"
        }, {
            name: "abbas",
            pass: "abbas123"
        }, {
            name: "user",
            pass: "user123"
        }
    ];


    return{
        authenticate: function(user) {
            var result = false;
            users.forEach(function(item) {
                if (item.name === user.name && item.pass === user.pass) {
                    $rootScope.authentication = user;
                    result = true;
                    return;
                }
            });

            return result;
        },
        login: function(user) {

            return $http({
                method: 'POST',
                data: user,
                url: 'auth',
                headers: {'Content-Type': 'application/json'}
            });

        },
        
         who: function(user) {

            return $http({
                method: 'GET',
                data: user,
                url: 'who',
                headers: {'Content-Type': 'application/json'}
            }); 
        }
    };
});