package com.shuratech.gis.api.service;

import com.shuratech.gis.api.CRUDInterface;
import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.Skill;
import com.shuratech.gis.api.model.SkillLevel;

import java.util.List;

/**
 *
 * @author abbas
 */
public interface SkillService extends CRUDInterface<Skill, Long>{

    /** 
     * get agent skills by agent.id 
     * @param agent
     * @return 
     */
    List<Skill> getAll(Agent agent);
    
    /** 
     * get enabled agent skills by agent.id 
     * @param agent
     * @return 
     */
    List<Skill> getEnabled(Agent agent);
    
    /** 
     * get disabled agent skills by agent.id 
     * @param agent
     * @return 
     */
    List<Skill> getDisbaled(Agent agent);
    Skill getSkillByName(String skillname);
    
     /** 
     * clear all disabled skills by agent.id
     * @param agent 
     * @return boolean ture if success
     */
    boolean clearDisabled(Agent agent);
    boolean addSkill(Agent agent, Skill skill,SkillLevel level);
    boolean addSkill(Agent agent, Skill skill);
    boolean removeSkill(Agent agent, Skill skill);
    
    
}
