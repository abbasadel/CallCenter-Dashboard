/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.shuratech.gis.fixture;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.Skill;
import com.shuratech.gis.api.model.SkillLevel;
import com.shuratech.gis.api.service.SkillService;
import com.shuratech.gis.templates.SkillTemplateLoader;

/**
 *
 * @author abbas
 */
public class SkillServiceFixture implements SkillService{
	
	@Autowired
	AgentServiceFixture agentServiceFixture;

	SkillTemplateLoader skill;
	public void load() {
        FixtureFactoryLoader.loadTemplates("com.shuratech.gis.templates");
    }
	
    @Override
    public List<Skill> getAll(Agent agent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Skill> getEnabled(Agent agent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Skill> getDisbaled(Agent agent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Skill getSkillByName(String skillname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean clearDisabled(Agent agent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addSkill(Agent agent, Skill skill, SkillLevel level) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addSkill(Agent agent, Skill skill) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	List<Agent> agents = agentServiceFixture.getAll();
    	for(Agent oldAgent: agents){
    		if(oldAgent.getEmployeeID()==agent.getEmployeeID()){
    			System.out.println("Employee ID is: "+oldAgent.getEmployeeID().toString());
    			if(oldAgent.getSkills() == null){
    			oldAgent.setSkills(new ArrayList<Skill>());
    			}
    			oldAgent.getSkills().add(skill);
    			return true;
    		}
    	}
    	return false;
    }

    @Override
    public boolean removeSkill(Agent agent, Skill skill) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Skill> getAll() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        load();
    	List<Skill> skills= Fixture.from(Skill.class).gimme(5, "skill"); 
    	System.out.println(skills);
    	return skills;
    }

    @Override
    public Skill get(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Skill create(Skill t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Skill update(Skill t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
