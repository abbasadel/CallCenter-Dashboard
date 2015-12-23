package com.shuratech.gis.impl.genesys.utils;

public enum GenesysTypes {
	Agent("Agent"),
	GroupAgents("GroupAgents");
	String type;
	private GenesysTypes(String type) {
		this.type = type;
	}
	public String getType(){
		return type;
	}
}
