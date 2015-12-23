'use strict';

myApp.controller('MainController', function($scope, $modal, GroupService,
        AgentService, NotificationService, AuthenticationService, $rootScope, $http) {

    var group = {};
    var agent = {};
    $scope.skillsList = new Array();

    AuthenticationService.who().success(function(user) {
        $scope.user = user;
    }).error(function() {
        window.location = "/login";
    });

    // $rootScope.authentication = null;
//
//    $scope.showLoginModal = function() {
//        var addLoginModal = $modal({scope: $scope, template: 'partials/login.html', show: true, backdrop: 'static'});
//        $scope.doLogin = function(username, password) {
//            var user = {username: username, password: password};
//            AuthenticationService.login(user)
//                    .error(function() {
//                    })
//                    .success(function() {
//                        addLoginModal.hide();
//
//                    });
//
//
//        };
//    };
//
//
//    if ($rootScope.authentication === null) {
//        $scope.showLoginModal();
//    }

    $scope.addToSkills = function(skill, level) {
        var skill = {skill: skill, level: level};
        $scope.skillsList.push(skill);
        this.skill = null;
    };

//    $scope.user = {
//        firstName: 'Mohamed',
//        lastName: 'Kishk',
//        fullname: function() {
//            return this.firstName + ' ' + this.lastName;
//        }
//    };

    $scope.totalActions = 54321;

//    var profileModal = $modal({scope: $scope, template:'partials/profile.html', show: false});

//    //show add agent model and save new agent method

//    $scope.showAddAgentModal = function() {
//
//
//
//        var addAgentModal = $modal({scope: $scope, template: 'partials/agent/add.html', show: false});
//        addAgentModal.$promise.then(addAgentModal.show);
//
//
//
//        $scope.groupList = $rootScope.groupList;
//         $http.get('/skillsList')
//                .success(function(skillsList) {
//                     $scope.skillList = skillsList;
//                    console.log(skillsList);
//                });
//
//
//
//        $scope.saveAgent = function(agent, groups, skillsList) {
//            AgentService.saveAgent(agent, groups, skillsList).success(function(data) {
//                NotificationService.success(data.message);
//                $scope.agent = null;
//                agent = null;
//            }).error(function(data) {
//                NotificationService.error(data.message);
//            });
//            addAgentModal.hide();
//        };
//    };

// // show add group modal
//    $scope.showAddGroupModal = function() {
//        var addGroupModal = $modal({scope: $scope, template: 'partials/group/add.html', show: false});
//        addGroupModal.$promise.then(addGroupModal.show);
//
//        $scope.save = function(group) {
//            GroupService.save(group).success(function(data) {
//                NotificationService.success(data.message);
//            }).error(function(data) {
//                NotificationService.error(data.message);
//            });
//            group = null;
//            addGroupModal.hide();
//        };
//    };



});