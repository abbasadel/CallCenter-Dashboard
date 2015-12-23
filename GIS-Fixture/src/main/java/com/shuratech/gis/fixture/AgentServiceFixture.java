package com.shuratech.gis.fixture;

import java.util.List;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.AgentGroup;

public class AgentServiceFixture implements com.shuratech.gis.api.service.AgentService {

	
	public static List<Agent> agents;
	
    public void load() {
        FixtureFactoryLoader.loadTemplates("com.shuratech.gis.templates");
    }

    public List<Agent> getAll() {
        load();
        if(agents == null){
            agents = Fixture.from(Agent.class).gimme(100, "agent");
        }
        return agents;
    }

    public List<Agent> getAll(final String start, int max) {
        // TODO Auto-generated method stub
        load();
        List<Agent> agents = Fixture.from(Agent.class).gimme(max, "agent", new Rule() {
            {
                add("employeeID", start);
            }
        });
        return agents;

    }

    public Agent get(final String id) {
        // TODO Auto-generated method stub
        load();
        Agent agent = Fixture.from(Agent.class).gimme("agent", new Rule() {
            {

                add("employeeID", id);
            }
        });
        return agent;
    }

    public Agent create(Agent t) {
        // TODO Auto-generated method stub
        load();
        t = Fixture.from(Agent.class).gimme("agent");
        return t;
    }

    public Agent update(Agent t) {
        // TODO Auto-generated method stub
        load();
        t = Fixture.from(Agent.class).gimme("agent");
//        if(getAll() != null){
//    	for(Agent agent: getAll()){
    		System.out.println("inside agent list");
//    		if (agent.getFirstName()==t.getFirstName() && agent.getEmployeeID()==t.getEmployeeID() 
//    			&& agent.getLastName() == t.getLastName()){
//    			agent = t ;
//    		}}}else{
//    			System.out.println("agents list is null");
//    		}
//    	}
    	return null;
    }

    public boolean delete(final String id) {
        // TODO Auto-generated method stub
        System.out.println("Agent No. " + id + " has been deleted");
        return true;
    }

    public List<Agent> getAll(final AgentGroup group) {
        // TODO Auto-generated method stub
        load();
        group.setName("customerService");
        List<Agent> agents = Fixture.from(Agent.class).gimme(5, "agent");
        return agents;
//		return null;
    }

    @Override
    public boolean updatePassword(Agent agent, String passdword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
