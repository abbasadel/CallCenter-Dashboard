package com.shuratech.gis.api.service;

import com.shuratech.gis.api.CRUDInterface;
import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.AgentGroup;
import java.util.List;

/**
 *
 * @author abbas
 */
public interface AgentService extends CRUDInterface<Agent, String> {

    /**
     * get all agents by group.name
     * @param group
     * @return 
     */
    List<Agent> getAll(AgentGroup group);

	boolean delete(String id);
	boolean updatePassword(Agent agent,String passdword);
	

}
