package com.shuratech.gis.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.AgentGroup;
import com.shuratech.gis.api.model.AgentStatusUpdate;
import com.shuratech.gis.api.service.AgentStatusService;
import com.shuratech.gis.api.service.GroupService;
import com.shuratech.gis.fixture.GroupServiceFixture;
import com.shuratech.gis.web.response.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class GroupController {

    @Autowired
    GroupService groupService;

    @Autowired
    AgentStatusService agentStatusService;

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public @ResponseBody
    List<AgentGroup> getAll() {
        List<AgentGroup> groups = groupService.getAll();
        return groups;
    }

    @RequestMapping(value = "/groups/{id}/agents", method = RequestMethod.GET)
    public @ResponseBody
    List<Agent> getGroupAgents(@PathVariable Long id) {
        List<Agent> agents = null;
        AgentGroup group = groupService.get(id);
        if (group != null) {
            agents = group.getAgents();
        }

        // getting status
        if (agents != null && agents.size() > 0) {
            List<AgentStatusUpdate> updates = agentStatusService.get(agents);

            for (AgentStatusUpdate update : updates) {
                for (Agent agent : agents) {
                    if (update != null && update.getAgent().getEmployeeID().equals(agent.getEmployeeID())) {
                        agent.setStatus(update.getStatus());
                    }
                }
            }
        }

        return agents;
    }

    @RequestMapping(value = "/groups/{id}",method= RequestMethod.GET)
    public @ResponseBody
    AgentGroup getGroup(@PathVariable Long id) {
        AgentGroup group = groupService.get(id);
        return group;
    }

    @RequestMapping(value = "/groups", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    JsonResponse save(@RequestBody AgentGroup group) {
        groupService.create(group);
        return JsonResponse.make("Save Operation Completed Successfully");
    }

    @RequestMapping(value = "/groups/{id}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    JsonResponse update(@RequestBody AgentGroup group, @PathVariable Long id) {
        groupService.update(group);
        return JsonResponse.make("Update Operation Completed Successfully");
    }

    @RequestMapping(value = "/groups/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    JsonResponse delete(@PathVariable Long id) {
        groupService.delete(id);
        return JsonResponse.make("Delete Operation Completed Successfully");
    }
}
