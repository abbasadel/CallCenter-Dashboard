angular.module('shura.directives', []).directive('tooltip', function($http) {
    return {
        restrict: 'A',
        link: function($scope, $elem, attrs) {
            var options = {};
            $elem.tooltip(options);
        }
    };
});