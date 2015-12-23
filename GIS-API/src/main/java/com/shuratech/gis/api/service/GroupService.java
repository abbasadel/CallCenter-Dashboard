package com.shuratech.gis.api.service;

import com.shuratech.gis.api.CRUDInterface;
import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.AgentGroup;
import java.util.List;

/**
 *
 * @author abbas
 */
public interface GroupService extends CRUDInterface<AgentGroup, Long> {

    /**
     * add agent to group
     *
     * @param agent
     * @param group
     * @return
     */
    boolean add(Agent agent, AgentGroup group);

    /**
     * add agents to group
     *
     * @param agents
     * @param group
     * @return
     */
    boolean add(List<Agent> agents, AgentGroup group);

    /**
     * remove agent from group
     *
     * @param agent
     * @param group
     * @return
     */
    boolean remove(Agent agent, AgentGroup group);

    /**
     * remove agents from group
     *
     * @param agents
     * @param group
     * @return
     */
    boolean remove(List<Agent> agents, AgentGroup group);

}
