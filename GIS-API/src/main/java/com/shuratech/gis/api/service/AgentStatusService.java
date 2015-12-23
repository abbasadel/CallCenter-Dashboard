package com.shuratech.gis.api.service;

import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.AgentGroup;
import com.shuratech.gis.api.model.AgentStatus;
import com.shuratech.gis.api.model.AgentStatusUpdate;

import java.util.List;
import java.util.Map;

/**
 *
 * @author abbas
 */
public interface AgentStatusService {
    
    /**
     * get Agent status by agent.id
     * @param agent
     * @return 
     */
    AgentStatusUpdate get(Agent agent);
    
    
    /**
     * get statuses for list of agents.id
     * @param agents
     * @return 
     */
    List<AgentStatusUpdate>  get(List<Agent> agents);
    
    
    /**
     * get statuses for group.name
     * @param group
     * @return 
     */
    List<AgentStatusUpdate> get(AgentGroup group);
    
    
    
}
