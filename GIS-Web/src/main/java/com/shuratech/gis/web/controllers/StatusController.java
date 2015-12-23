    package com.shuratech.gis.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;

import com.shuratech.gis.api.model.AgentGroup;
import com.shuratech.gis.api.model.AgentStatusUpdate;
import com.shuratech.gis.api.service.AgentStatusService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class StatusController {

    @Autowired
    AgentStatusService agentStatusService;


    @RequestMapping(value = "/status/group/{id}")
    public @ResponseBody
    List<AgentStatusUpdate> getGroupStatus(@PathVariable Long id, HttpSession session) {
        return agentStatusService.get(new AgentGroup(id));
    }
}
