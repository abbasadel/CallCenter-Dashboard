'use strict';

myApp.directive('widget', function() {
    return {
        restrict: 'E',
        transclude: true,
        templateUrl: 'partials/widget.html',
        scope: {
            title: '@title'
        }
    };
});