package com.shuratech.gis.web.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.AgentGroup;
import com.shuratech.gis.api.model.Skill;
import com.shuratech.gis.api.model.User;
import com.shuratech.gis.api.service.AgentService;
import com.shuratech.gis.api.service.GroupService;
import com.shuratech.gis.api.service.SkillService;
import com.shuratech.gis.web.response.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class AgentController {

    Logger logger = Logger.getLogger(AgentController.class);

    @Autowired
    AgentService agentService;

    @Autowired
    GroupService groupService;

    @Autowired
    SkillService skillService;

    @RequestMapping(value = "/agents", method = RequestMethod.GET)
    public @ResponseBody
    List<Agent> getAll() {
        logger.info("executing getAll method");
        List<Agent> agents = agentService.getAll();
        return agents;
    }

    @RequestMapping(value = "/agents", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    JsonResponse save(@RequestBody Agent agent) {
        User dummy = new User(agent.getFirstName(), agent.getLastName());
        agent.setCredential(dummy);
        Agent newagent = agentService.create(agent);
        if (agent.getGroups() != null) {
            for (AgentGroup group : agent.getGroups()) {
                groupService.add(newagent, group);
            }
        }

        if (agent.getSkills() != null) {
            for (Skill skill : agent.getSkills()) {
                skillService.addSkill(newagent, skill, skill.getLevel());
            }
        }

        return JsonResponse.make("New Agent created Successfully");
    }
    
    @RequestMapping(value="/agents/addsKill",method=RequestMethod.POST,headers={"content-type=application/json"})
    public @ResponseBody JsonResponse addSkill(@RequestBody List<Agent> agents){
    	System.out.println(agents.toString());
    	if(agents != null){
    	for(Agent agent:agents){
    		for(Skill skill:agent.getSkills()){
    			if(skillService.addSkill(agent,skill)== true){
    		    	return JsonResponse.make("skills added to agents successfully");
    			}
    		}
    	}
    }
    	return null;
    }
    

}
