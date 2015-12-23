'use strict';

myApp.factory('AgentService', function($http) {

    return {
        // get all the comments
        get: function(id) {
            return $http.get('/groups/' + id + '/agents/');
        },
        // save a comment (pass in comment data)
        saveAgent: function(agent, groups, skills) {
            agent.groups = new Array();
            groups.forEach(function(group) {
                agent.groups.push({id: group});
            });

            agent.skillsList = new Array();
            skills.forEach(function(skill) {
                agent.skillsList.push({name: skill.skill, level:skill.level});
            });

            console.log(agent);

            return $http({
                method: 'POST',
                data: JSON.stringify(agent),
                url: 'agents',
                headers: {'Content-Type': 'application/json'}
            });
        },
        //update agents after adding skills
        updateAgent: function(agents){
            var updatedAgents = new Array();
            agents.forEach(function(agent){
                updatedAgents.push({'employeeID':agent.employeeID,'skills':agent.skills});
            });
            return $http({
                method: 'POST',
                data: updatedAgents,
                url: 'agents/addsKill',
                headers: {'Content-Type': 'application/json'}
            });
        },
        // destroy a comment
        destroy: function(id) {
            return $http.delete('/api/comments/' + id);
        }
    }

});
	