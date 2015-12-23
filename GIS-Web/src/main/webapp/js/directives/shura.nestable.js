angular.module('shura.directives', []).directive('nestable', function() {
    return {
        restrict: 'A',
        link: function($scope, $elem, attrs) {
            var options = {};
            $elem.nestable(options);
        }
    };
});