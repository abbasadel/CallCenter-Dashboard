package com.shuratech.gis.impl.genesys.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.genesyslab.platform.applicationblocks.com.ConfService;
import com.genesyslab.platform.applicationblocks.com.ConfigException;
import com.genesyslab.platform.applicationblocks.com.objects.CfgAgentGroup;
import com.genesyslab.platform.applicationblocks.com.objects.CfgAgentInfo;
import com.genesyslab.platform.applicationblocks.com.objects.CfgAgentLoginInfo;
import com.genesyslab.platform.applicationblocks.com.objects.CfgPerson;
import com.genesyslab.platform.applicationblocks.com.queries.CfgAgentGroupQuery;
import com.genesyslab.platform.applicationblocks.com.queries.CfgPersonQuery;
import com.shuratech.gis.api.exceptions.GISGeneralExceptions;
import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.AgentGroup;
import com.shuratech.gis.api.model.AgentLogin;
import com.shuratech.gis.api.service.AgentService;
import com.shuratech.gis.api.service.AgentStatusService;
import com.shuratech.gis.impl.genesys.utils.GenesysUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class AgentServiceImp extends ServcieImp implements AgentService {
    
    
    @Autowired
    AgentStatusService agentStatusService;

    public AgentServiceImp(ConfService userConfService) {
        super(userConfService);
    }

    @Override
    public List<Agent> getAll() throws GISGeneralExceptions {
        ArrayList<Agent> persons = new ArrayList<Agent>();
        CfgPersonQuery query = new CfgPersonQuery(userConfService);
        query.setIsAgent(0);
        try {
            GenesysUtils.openIfClosed(userConfService);
            System.out.println(userConfService.getProtocol().getState().toString());
            Iterator<CfgPerson> list = query.execute().iterator();
            System.out.println(userConfService.getProtocol().getState().toString());
            while (list != null && list.hasNext()) {

                CfgPerson person = list.next();

                Agent agent = new Agent();
                agent.setEmail(person.getEmailAddress());
                agent.setEmployeeID(person.getEmployeeID());
                agent.setFirstName(person.getFirstName());
                CfgAgentInfo agentLogins = person.getAgentInfo();
				//System.out.println(userConfService.getProtocol().getState().toString());

                if (agentLogins.getAgentLogins() != null) {
                    Iterator<CfgAgentLoginInfo> logins = agentLogins
                            .getAgentLogins().iterator();
                    while (logins.hasNext()) {
                        CfgAgentLoginInfo info = logins.next();
                        String shortCode = "";
                        if (info.getAgentLogin() != null) {
                            shortCode = info.getAgentLogin().getLoginCode();
                        }
                        int dbID = info.getAgentLogin().getDBID();
                        int switchDBID = info.getAgentLogin().getSwitchDBID();
                        AgentLogin logins2 = new AgentLogin();
                        logins2.setSwitchID(switchDBID);
                        logins2.setDbID(dbID);
                        logins2.setLoginCode(shortCode);
                        agent.getLoginIDs().add(logins2);
                    }
                }
//				Collection<CfgSkillLevel> skilllevels = agentLogins
//						.getSkillLevels();
//				if (skilllevels != null) {
//					Iterator<CfgSkillLevel> iterator = skilllevels.iterator();
//					ArrayList<Skill>skills=new ArrayList<>();
//					agent.setSkills(skills);
//					while (iterator.hasNext()) {
//						CfgSkillLevel level = iterator.next();
//						int levels = level.getLevel();
//						String skillName = level.getSkill().getName();
//						Skill skill = new Skill();
//						skill.setName(skillName);
//						skill.setLevel(SkillLevel.getByValue(levels));
//						agent.getSkills().add(skill);
//					}
//				}
//				ArrayList<CfgAgentGroup> groups = getAgentGroup(person
//						.getDBID(),false);
//				ArrayList<AgentGroup> groupsList = new ArrayList<>(); 
//				agent.setGroups(groupsList);
//				for (CfgAgentGroup group : groups) {
//					AgentGroup temp = new AgentGroup();
//					temp.setName(group.getGroupInfo().getName());
//					agent.getGroups().add(temp);
//				}
                persons.add(agent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        GenesysUtils.closeIfOpened(userConfService);
        return persons;
    }

  

    public Agent get(String id) {
        GenesysUtils.openIfClosed(userConfService);
        CfgPersonQuery query = new CfgPersonQuery(userConfService);
        query.setIsAgent(2);
        query.setEmployeeId(id);
        Agent agent = null;
        try {
            CfgPerson person = query.executeSingleResult();
            agent = mapAgentGenesysObject(person);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            GenesysUtils.closeIfOpened(userConfService);
        }
        return agent;
    }

    @Override
    public Agent create(Agent t) {
        Agent temp = null;
        CfgPerson person = mapAgentObject(t);
        person.setTenantDBID(101);
        GenesysUtils.openIfClosed(userConfService);
        try {

            userConfService.saveObject(person);
            temp = mapAgentGenesysObject(person);
        } catch (Exception e) {
            e.printStackTrace();
            throw new GISGeneralExceptions("Can't add Agent");

        } finally {
            GenesysUtils.openIfClosed(userConfService);
        }

        return temp;
    }

    // We need to break that method as it's more generic
    @Override
    public Agent update(Agent t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean delete(String id) {
        GenesysUtils.openIfClosed(userConfService);
        CfgPersonQuery query = new CfgPersonQuery(userConfService);
        query.setEmployeeId(id);
        query.setIsAgent(2);
        boolean result = false;
        try {
            CfgPerson person = query.executeSingleResult();
            //set id
            person.delete();
            result = true;
        } catch (Exception e) {
			// TODO Auto-generated catch block
            // e.printStackTrace();
        } finally {
            GenesysUtils.closeIfOpened(userConfService);
        }
        return result;
    }

    @Override
    public List<Agent> getAll(AgentGroup group) {
        GenesysUtils.openIfClosed(userConfService);
        ArrayList<Agent> list = new ArrayList<Agent>();
        CfgAgentGroupQuery query = new CfgAgentGroupQuery(userConfService);
        query.setName(group.getName());
        try {
            CfgAgentGroup groups = query.executeSingleResult();
            ArrayList<CfgPerson> arrayList = new ArrayList<CfgPerson>();
            arrayList.addAll(groups.getAgents());
            for (CfgPerson person : arrayList) {
                Agent agent = mapAgentGenesysObject(person);
                list.add(agent);
            }
            
        } catch (Exception e) {

        }
        GenesysUtils.closeIfOpened(userConfService);
        return list;
    }

    @Override
    public boolean updatePassword(Agent agent, String password) {
        boolean result = false;
        GenesysUtils.openIfClosed(userConfService);
        CfgPersonQuery query = new CfgPersonQuery(userConfService);
        query.setIsAgent(2);
        query.setEmployeeId(agent.getEmployeeID());
        try {
            CfgPerson cfgPerson = query.executeSingleResult();
            cfgPerson.setPassword(password);
            cfgPerson.save();
            result = true;
        } catch (ConfigException e) {
            // TODO Auto-generated catch block
            result = false;
            e.printStackTrace();
        }

        return result;
    }

}
