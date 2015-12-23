package com.shuratech.gis.fixture;

import java.util.List;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

import com.shuratech.gis.api.model.Agent;	
import com.shuratech.gis.api.model.AgentGroup;

public class InMemoDB {

	public static final List<AgentGroup> groups;
	static {
		FixtureFactoryLoader.loadTemplates("com.shuratech.gis.templates");
		groups = Fixture.from(AgentGroup.class).gimme(20, "group");
		for (int i = 0; i < groups.size(); i++) {
			List<Agent> agents = Fixture.from(Agent.class).gimme(50, "agent");
			groups.get(i).setAgents(agents);
		}
	}
}
