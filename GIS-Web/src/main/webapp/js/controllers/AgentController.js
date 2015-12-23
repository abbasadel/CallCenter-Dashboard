'use strict';

myApp.controller('AgentController', function($scope, $http, $interval , AgentSkillService ,  AgentService , StatusService, timeAgo, nowTime, $rootScope,$modal) {
    $scope.timer = 5000;
    $scope.loading = true;
    $scope.toggle= false;
    $scope.myTooltip = {title: 'stop update'};
    $scope.userSkills = new Array();

    var defaultGroupId = $rootScope.firstValue;

    $scope.update=function(){
        $rootScope.get();
    }

    $scope.controlStatus = function(){
        if ($scope.toggle === true){
            document.getElementById("statusControl").className="badge  bg-color-redLight";
            $scope.myTooltip = {title: 'stop update'};
            $scope.toggle= false;
            $scope.updateCycle = $interval($scope.update, $scope.timer);
        }else if($scope.toggle === false){
            document.getElementById("statusControl").className="badge bg-color-green";
            $scope.myTooltip = {title: 'update status'};
            $scope.toggle = true;
            $interval.cancel($scope.updateCycle);
        }
    };

    $scope.openSkillModal = function(){
          $scope.skillsList = new Array();
          AgentSkillService.get().success(function(data){
              if($scope.selectedUsers.length !== 0){
              $scope.openModal = $modal({scope: $scope, template: 'partials/skills.html', show: false});
              $scope.openModal.$promise.then($scope.openModal.show);
              $scope.skillsList= data;
              console.log($scope.skillsList);
              }else{
                  alert("You should select user first");
              }
          });
    };


    $rootScope.get = function(selectedGroupId) {
        if (selectedGroupId === null) {
            selectedGroupId = defaultGroupId;
        } else {
            defaultGroupId = selectedGroupId;
        }
        AgentService.get(defaultGroupId)
                .success(function(data) {
                    updateStatusCounts(data);
                    $scope.agents = data;
                    $scope.loading = false;
                    $scope.firstGroupName = $rootScope.selectedGroupName;
                });
    };



    //call status for update

    $scope.update = function() {
        var agents = new Array();




        StatusService.get(defaultGroupId).success(function(data) {

            $scope.agents.forEach(function(agent) {
                data.forEach(function(agentStatus) {

                    if (agentStatus.agent.employeeID === agent.employeeID) {
                        agent.status = agentStatus.status;
                        if(agentStatus.updated !== null ){
                            agent.status.updatedAt = agentStatus.updated*1000;
                        }
                        return;
                    }

                });
                agents.push(agent);
            });
            $scope.agents = agents;

            //update counts
            updateStatusCounts(data);




        });

    };


    function updateStatusCounts(statusList) {

        var successCount = 0;
        var warningCount = 0;
        var dangerCount = 0;
        var defaultCount = 0;
        var totalCount = 0;

        statusList.forEach(function(item) {
            if (item.status === null) {
                item.status = {
                    color: 'DEFAULT',
                    updatedAt: null,
                    label: 'Loading...'
                };
            } 
            else if(typeof item.status.updatedAt === 'undefined'){
                item.status.updatedAt = null;
            }


            totalCount += 1;
            if (item.status.color === 'SUCCESS')
                successCount += 1;
            if (item.status.color === 'WARNING')
                warningCount += 1;
            if (item.status.color === 'DANGER')
                dangerCount += 1;
            if (item.status.color === 'DEFAULT')
                defaultCount += 1;

        });

        $scope.readyPercent = successCount * 100 / totalCount;
        $scope.warningCount = warningCount;
        $scope.dangerCount = dangerCount;
        $scope.successCount = successCount;
        $scope.defaultCount = defaultCount;
    }


    $scope.updateCycle = $interval($scope.update, $scope.timer);

    $scope.message = '';

    $scope.myCallback = function(nRow, aData, iDisplayIndex, iDisplayIndexFull) {
        $scope.selectedUsers= new Array();
        //handle click on checkbox

        $("input[type='checkbox']",nRow ).bind('click', function() {
            if(!$("input[type='checkbox']",nRow).is(':checked')) {
                var i = $scope.selectedUsers.indexOf(aData.employeeID);
                $scope.selectedUsers.splice(i,1);
                console.log($scope.selectedUsers);
            }else {
                $scope.selectedUsers.push(aData);
                console.log($scope.selectedUsers);
            }
        });
        // handle click on row except checkbox
        $('td:not(:first)' ,nRow).bind('click',function(){
            $scope.showAgentDetails(aData);
            });

        return nRow;
    };


    $scope.showAgentDetails= function(agentData){
        $scope.modalData = agentData;
        var showAgentDetails = $modal({scope: $scope , template: 'partials/agent/agentDetails.html', show: false});
        showAgentDetails.$promise.then(showAgentDetails.show);
        console.log(agentData);
    };

    $scope.addSkill = function(skill,level){
        var addedskill = {name: skill , level: level};
        $scope.userSkills.push(addedskill);
        console.log($scope.userSkills);
    }

    $scope.someClickHandler = function(info) {
        $scope.message = 'clicked: ' + info.price;
//        alert("in someClickHandler method");
    };

    $scope.matchAgentSkills = function(agentlist, skilllist){
        agentlist.forEach(function(agent){
            agent.skills = skilllist;
        });
//        var listAgent = [{credential: null, disabledSkills: null, email: "Josef@yahoo.com", employeeID: "a2", firstName: "Josef",
//            groups: [{name:"Marketing", agents:null, id:99}, {name:"Marketing", agents:null, id:193}], lastName: "Walsh", loginID: "239090",
//            loginIDs: [], skills:[{name:"communication skills",level:"Low"}],// enabled:null}],//, $$hashKey:"01N"
//            status:null//{label:"Not Ready",color:"WARNING"}//, updatedAt:null
//    }];
//        var listAgent = [{firstName:'ahmed',lastName:'zaki'},{firstName:'mohamed',lastName:'adel'}];
        console.log(agentlist);
        AgentService.updateAgent(agentlist);
        $scope.openModal.hide();
    };


    $scope.columnDefs = [
        {
            "mDataProp": "employeeID",
            "aTargets": [0],
            "bSortable": false,
            "mRender": function(data, type, full) {
                return "<input type='checkbox'>";
            }
        },
        {"mDataProp": "firstName", "aTargets": [1]},
        {"mDataProp": "lastName", "aTargets": [2]},
        {
            "mDataProp": "status",
            "aTargets": [3],
            "mRender": function(data, type, full) {
                return '<span class="label label-' + data.color.toLowerCase() + '">' + data.label + '</span>';
            }
        },
        {"mDataProp": "employeeID", "aTargets": [4]},
        {
            "mDataProp": "status.updatedAt",
            "aTargets": [5],
            "mRender": function(data, type, full) {
                if (data === null || data < 0)
                    return null;
                var fromTime = timeAgo.parse(data);
                var diff = nowTime() - fromTime;
                //console.log(nowTime() + ' vs '  + Date.now()  + ' - ' + fromTime + ' ' + diff + ' |  ' + data);

                return timeAgo.inWords(diff);
            }
        }
    ];

    $scope.overrideOptions = {};

    if ($("[rel=tooltip]").length) {
        $("[rel=tooltip]").tooltip();
    }

});
