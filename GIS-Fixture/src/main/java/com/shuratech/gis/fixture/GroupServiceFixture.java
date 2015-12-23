package com.shuratech.gis.fixture;

import java.util.List;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.AgentGroup;
import org.springframework.stereotype.Component;

public class GroupServiceFixture implements com.shuratech.gis.api.service.GroupService {

    public void load() {
        FixtureFactoryLoader.loadTemplates("com.shuratech.gis.templates");
    }

    public List<AgentGroup> getAll() {
        // TODO Auto-generated method stub
        return InMemoDB.groups;
//		List<AgentGroup> agentGroup = Fixture.from(AgentGroup.class).gimme(15,"group");
//		return agentGroup;
    }

    public AgentGroup get(final Long id) {
        // TODO Auto-generated method stub
//		load();
        for (AgentGroup group : InMemoDB.groups) {
            if (group.getId() == id) {
                return group;
            }
        }
        return InMemoDB.groups.get(1);
//		AgentGroup agentGroup= Fixture.from(AgentGroup.class).gimme("group", new Rule(){{
//			add("id",id);
//		}});
//		return agentGroup;
    }

    public AgentGroup create(AgentGroup t) {
        // TODO Auto-generated method stub
//		load();
//		t = Fixture.from(AgentGroup.class).gimme("group");
//		return t;
        InMemoDB.groups.add(t);
        return t;
    }

    public AgentGroup update(AgentGroup t) {
        for (AgentGroup group : InMemoDB.groups) {
            if (group.getId() == t.getId()) {
                group.setName(t.getName());
                return group;
            }
        }
        return null;
    }

    public boolean delete(Long id) {
        for (AgentGroup agent : InMemoDB.groups) {
            if (agent.getId() == id) {
                InMemoDB.groups.remove(agent);
                return true;
            }
        }
        return false;
    }

    public boolean add(Agent agent, AgentGroup group) {
        // TODO Auto-generated method stub
        load();
        agent = Fixture.from(Agent.class).gimme("agent");
        group = Fixture.from(AgentGroup.class).gimme("group");
        if (agent != null && group != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean add(List<Agent> agents, AgentGroup group) {
        // TODO Auto-generated method stub
        load();
        agents = Fixture.from(Agent.class).gimme(5, "agent");
        group = Fixture.from(AgentGroup.class).gimme("group");
        if (agents != null & group != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(Agent agent, AgentGroup group) {
        // TODO Auto-generated method stub
        System.out.println("removal process completed successfully");
        return true;
    }

    public boolean remove(List<Agent> agents, AgentGroup group) {
        // TODO Auto-generated method stub
        System.out.println("removal process completed successfully");
        return true;
    }

}
