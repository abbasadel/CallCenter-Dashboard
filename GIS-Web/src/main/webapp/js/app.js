'use strict';


// Declare app level module which depends on filters, and services
var myApp = angular.module('myApp', 
    ['ngRoute','myApp.filters', 'shura.directives', 'yaru22.angular-timeago','mgcrea.ngStrap']).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/agents', {templateUrl: 'views/agents.html', controller: 'AgentController'});
  $routeProvider.when('/view2', {templateUrl: 'partials/partial2.html', controller: 'MyCtrl2'});
  $routeProvider.otherwise({redirectTo: '/agents'});
}]);

