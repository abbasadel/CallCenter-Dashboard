package com.shuratech.gis.impl.genesys.service;

import java.util.ArrayList;
import java.util.List;

import com.genesyslab.platform.applicationblocks.com.ConfService;
import com.genesyslab.platform.applicationblocks.com.ConfigException;
import com.genesyslab.platform.applicationblocks.com.objects.CfgAgentGroup;
import com.genesyslab.platform.applicationblocks.com.objects.CfgAgentInfo;
import com.genesyslab.platform.applicationblocks.com.objects.CfgGroup;
import com.genesyslab.platform.applicationblocks.com.objects.CfgPerson;
import com.genesyslab.platform.applicationblocks.com.queries.CfgAgentGroupQuery;
import com.genesyslab.platform.applicationblocks.com.queries.CfgPersonQuery;
import com.shuratech.gis.api.exceptions.GISGeneralExceptions;
import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.AgentGroup;
import com.shuratech.gis.api.service.AgentService;
import com.shuratech.gis.api.service.GroupService;
import com.shuratech.gis.impl.genesys.utils.GenesysUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class GroupServiceImp extends ServcieImp implements GroupService {
    
    @Autowired
    AgentService agentService;

    public GroupServiceImp(ConfService userConfService) {
        super(userConfService);
    }

    @Override
    public List<AgentGroup> getAll() throws GISGeneralExceptions {
        ArrayList<AgentGroup> groups = new ArrayList<AgentGroup>();
        GenesysUtils.openIfClosed(userConfService);
        CfgAgentGroupQuery groupQuery = new CfgAgentGroupQuery(userConfService);
        ArrayList<CfgAgentGroup> agentGroups = new ArrayList<CfgAgentGroup>();
        try {
            agentGroups.addAll(groupQuery.execute());
            for (CfgAgentGroup cfgAgentGroup : agentGroups) {
                groups.add(mapGenesysOpject(cfgAgentGroup));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new GISGeneralExceptions("Failed To Get Agent Group");
        }
        return groups;
    }

   

    @Override
    public AgentGroup get(Long id) {
        GenesysUtils.openIfClosed(userConfService);
        CfgAgentGroupQuery groupQuery = new CfgAgentGroupQuery(userConfService);
        AgentGroup agentGroup = null;
        groupQuery.setDbid(id.intValue());
        try {
            CfgAgentGroup group = groupQuery.executeSingleResult();
            agentGroup =  mapGenesysOpject(group);
        } catch (Exception e) {
            e.printStackTrace();
            throw new GISGeneralExceptions("Failed To Get Agent Group");
        }
        
        List<Agent> agents = agentService.getAll(agentGroup);
        agentGroup.setAgents(agents);
        
        return agentGroup;

    }

    @Override
    public AgentGroup create(AgentGroup t) {
        GenesysUtils.openIfClosed(userConfService);
        CfgAgentGroup group = new CfgAgentGroup(userConfService);
        CfgGroup cfgGroup = new CfgGroup(userConfService, group);
        cfgGroup.setName(t.getName());
        //it will change
        cfgGroup.setTenantDBID(101);
        group.setGroupInfo(cfgGroup);

        try {
            group.save();
            group.refresh();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        t.setId(new Long(group.getDBID()));

        return t;
    }

    @Override
    public AgentGroup update(AgentGroup t) {
        GenesysUtils.openIfClosed(userConfService);
        CfgAgentGroupQuery groupQuery = new CfgAgentGroupQuery(userConfService);
        groupQuery.setDbid(t.getId().intValue());
        try {
            CfgAgentGroup group = groupQuery.executeSingleResult();
            group.getGroupInfo().setName(t.getName());
            group.save();
            return t;
        } catch (Exception e) {
            //Define Exception
            return null;
        }

    }

    @Override
    public boolean delete(Long id) {
        GenesysUtils.openIfClosed(userConfService);
        CfgAgentGroupQuery groupQuery = new CfgAgentGroupQuery(userConfService);
        groupQuery.setDbid(id.intValue());
        try {
            CfgAgentGroup group = groupQuery.executeSingleResult();
            group.delete();
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //throw new GISGeneralExceptions("Failed To Get Agent Group");
            return false;
        }

    }

    @Override
    public boolean add(Agent agent, AgentGroup group) {
        return add(agent, group, true);

    }

    protected boolean add(Agent agent, AgentGroup group, boolean connection) {
        if (connection) {
            GenesysUtils.openIfClosed(userConfService);
        }
        CfgAgentGroupQuery groupQuery = new CfgAgentGroupQuery(userConfService);
        if (group.getId() != 0) {
            groupQuery.setDbid(group.getId().intValue());
        } else {
            groupQuery.setName(group.getName());
        }
        CfgPersonQuery personQuery = new CfgPersonQuery(userConfService);
        personQuery.setEmployeeId(agent.getEmployeeID());
        try {
            CfgAgentGroup cfggroup = groupQuery.executeSingleResult();
            CfgPerson person = personQuery.executeSingleResult();
            cfggroup.getAgents().add(person);
            cfggroup.save();

            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //throw new GISGeneralExceptions("Failed To Get Agent Group");
            return false;
        } finally {
            if (connection) {
                GenesysUtils.closeIfOpened(userConfService);
            }
        }

    }

    @Override
    public boolean add(List<Agent> agents, AgentGroup group) {
        try {
            GenesysUtils.openIfClosed(userConfService);
            for (Agent agent : agents) {
                add(agent, group, false);
            }
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            GenesysUtils.closeIfOpened(userConfService);
        }

    }

    @Override
    public boolean remove(Agent agent, AgentGroup group) {

        return remove(agent, group, true);
    }

    public boolean remove(Agent agent, AgentGroup group, boolean connection) {
        if (connection) {
            GenesysUtils.openIfClosed(userConfService);
        }
        CfgAgentGroupQuery groupQuery = new CfgAgentGroupQuery(userConfService);
        if (group.getId() != 0) {
            groupQuery.setDbid(group.getId().intValue());
        } else {
            groupQuery.setName(group.getName());
        }
        CfgPersonQuery personQuery = new CfgPersonQuery(userConfService);
        personQuery.setEmployeeId(agent.getEmployeeID());
        try {
            CfgAgentGroup cfggroup = groupQuery.executeSingleResult();
            CfgPerson person = personQuery.executeSingleResult();

            //.remove(person);
            ArrayList<CfgPerson> newList = new ArrayList<CfgPerson>();
            for (CfgPerson cfgPerson : cfggroup.getAgents()) {
                if (person.getDBID() != cfgPerson.getDBID()) {
                    newList.add(cfgPerson);
                }
            }
            cfggroup.setAgents(newList);
            cfggroup.save();

            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //throw new GISGeneralExceptions("Failed To Get Agent Group");
            return false;
        } finally {
            if (connection) {
                GenesysUtils.closeIfOpened(userConfService);
            }
        }
    }

    @Override
    public boolean remove(List<Agent> agents, AgentGroup group) {
        try {
            GenesysUtils.openIfClosed(userConfService);
            for (Agent agent : agents) {
                remove(agent, group, false);
            }
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            GenesysUtils.closeIfOpened(userConfService);
        }
    }

 
}
