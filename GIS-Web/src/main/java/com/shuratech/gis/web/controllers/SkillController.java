/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shuratech.gis.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.Skill;
import com.shuratech.gis.fixture.SkillServiceFixture;
import com.shuratech.gis.web.response.JsonResponse;

/**
 *
 * @author abbas
 */
@Controller

public class SkillController {

//    Logger logger = Logger.getLogger(AgentController.class);

//    @Autowired
//    SkillService skillService;

    @RequestMapping(value = "/skills", method = RequestMethod.GET)
    public @ResponseBody List<Skill> getAll() {
    	SkillServiceFixture fixture = new SkillServiceFixture();
    	List<Skill> skills = fixture.getAll();
    	return skills;
    };
};
