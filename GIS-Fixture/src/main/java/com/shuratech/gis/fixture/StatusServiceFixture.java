package com.shuratech.gis.fixture;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.function.DateTimeFunction;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.AgentGroup;
import com.shuratech.gis.api.model.AgentStatus;
import com.shuratech.gis.api.model.AgentStatusUpdate;
import com.shuratech.gis.api.service.AgentStatusService;
import com.shuratech.gis.api.service.GroupService;
import com.shuratech.gis.templates.AgentTemplateLoader;
import com.shuratech.gis.templates.EnumFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class StatusServiceFixture implements AgentStatusService {

    @Autowired
    GroupService groupService;

    EnumFunction enumFun = new EnumFunction(AgentStatus.class, 1);

    AgentTemplateLoader agentTemplate;

    public void load() {
        FixtureFactoryLoader.loadTemplates("com.shuratech.gis.templates");
    }

    public List<AgentStatus> getAll() {
        load();
        enumFun = new EnumFunction(AgentStatus.class, 10);
        List<AgentStatus> status = enumFun.generateValue();
        return status;
    }

    @Override
    public List<AgentStatusUpdate> get(final AgentGroup group) {
        List<AgentStatusUpdate> updatedAgentsList;
        updatedAgentsList = new ArrayList<AgentStatusUpdate>();
        List<Agent> agents = groupService.get(group.getId()).getAgents();
        Calendar startTime = Calendar.getInstance();
        Calendar endTime = Calendar.getInstance();
        startTime.add(Calendar.SECOND, -3000);
        DateTimeFunction dateEnumFunction = new DateTimeFunction(startTime, endTime);
        for (Agent agent : agents) {
            Calendar updateTime = dateEnumFunction.generateValue();
//			System.out.println(updateTime.getTimeInMillis());
            AgentStatus status = enumFun.generateValue().get(0);
            AgentStatusUpdate agentStatusUpdate = new AgentStatusUpdate();
            agentStatusUpdate.setAgent(agent);
            agentStatusUpdate.setStatus(status);
            agentStatusUpdate.setUpdated(updateTime.getTimeInMillis());
            updatedAgentsList.add(agentStatusUpdate);
        }
        return updatedAgentsList;
    }

    @Override
    public AgentStatusUpdate get(Agent agent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AgentStatusUpdate> get(List<Agent> agents) {
        return new ArrayList<AgentStatusUpdate>();
    }
}
