package com.shuratech.gis.api.model;

import java.util.List;

/**
 *
 * @author abbas
 */
public class AgentGroup {


    private String name;
    private List<Agent> agents;
    private Long id;
    //setters and getters

    public AgentGroup() {
    }

    public AgentGroup(Long id) {
        this.id = id;
    }

    public AgentGroup(String name, List<Agent> agents, Long id) {
        this.name = name;
        this.agents = agents;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

}
