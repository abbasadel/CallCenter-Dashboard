package com.shuratech.gis.api.model;

import java.util.List;

/**
 *
 * @author abbas
 */
public class Skill {

    private String name;
    private SkillLevel level;
    private List<Agent> agents;
    private boolean enabled;
    
    //setters and getters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SkillLevel getLevel() {
        return level;
    }

    public void setLevel(SkillLevel level) {
        this.level = level;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    

}
