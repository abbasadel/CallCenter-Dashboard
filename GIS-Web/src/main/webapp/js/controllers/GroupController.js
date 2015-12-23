'use strict';

myApp.controller('GroupController', function($scope, $http, GroupService, $modal, $rootScope, NotificationService) {
    $scope.loading = true;

    $scope.updateGroups = function() {
        GroupService.get()
                .success(function(data) {
                    $scope.groups = data;
                    $scope.loading = false;
                    $rootScope.groupList = $scope.groups;
                    // getting agents of first group to be displayed in agents view
                    $rootScope.firstValue = $scope.groups[0].id;
                    $rootScope.selectedGroupName = $scope.groups[0].name;
                    $rootScope.get($rootScope.firstValue);
                });
    };


    $scope.refreshGroups = function() {
        $scope.updateGroups();
        $('.nestable').nestable();

    }


    $scope.getFirstVal = function(group) {
        return  $rootScope.selectedGroup = $scope.groups[0].id;
    }

    $scope.updateGroups();

//    $scope.openEditGroupModal = function(group) {
//        $scope.copy = {name: group.name, id: group.id};
//        $scope.group = group;
//        var editGroupModal = $modal({scope: $scope, template: 'partials/group/edit.html', show: false});
//        editGroupModal.$promise.then(editGroupModal.show);
//        console.log(group);
//        $scope.save = function() {
//            group.name = $scope.copy.name;
//            GroupService.update(group)
//                    .success(function(data) {
//                        NotificationService.success(data.message);
//                    }).error(function(data) {
//                NotificationService.error(data.message);
//            });
//            editGroupModal.hide();
//        };
//    };

//    $scope.openDeleteGroupModal = function(group) {
//        $scope.group = group;
//        var deleteGroupModal = $modal({scope: $scope, template: 'partials/group/delete.html', show: false});
//        deleteGroupModal.$promise.then(deleteGroupModal.show);
//
//        $scope.delete = function() {
//            GroupService.delete(group)
//                    .success(function(data) {
//                        NotificationService.success(data.message);
//                    }).error(function(data) {
//                NotificationService.error(data.message);
//            });
//            deleteGroupModal.hide();
//            $scope.updateGroups();
//        }
//    }

    $scope.getAgent = function(group) {
        $rootScope.selectedGroup = group.id;
        $rootScope.selectedGroupName = group.name;
        $rootScope.get(group.id);
    };



    $scope.isSelected = function(group) {
        return $rootScope.selectedGroup === group.id;
    }
    $scope.groupLine = {};

});