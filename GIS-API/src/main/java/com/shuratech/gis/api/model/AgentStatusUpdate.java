package com.shuratech.gis.api.model;


public class AgentStatusUpdate {

	Agent agent;
	Long updated;
	AgentStatus status;
	
	
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public Long getUpdated() {
		return updated;
	}
	public void setUpdated(Long l) {
		this.updated = l;
	}
	public AgentStatus getStatus() {
		return status;
	}
	public void setStatus(AgentStatus status) {
		this.status = status;
	}
}
