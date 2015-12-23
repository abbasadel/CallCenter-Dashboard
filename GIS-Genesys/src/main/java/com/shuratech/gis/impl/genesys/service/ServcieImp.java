package com.shuratech.gis.impl.genesys.service;

import com.genesyslab.platform.applicationblocks.com.ConfService;
import com.genesyslab.platform.applicationblocks.com.objects.CfgAgentGroup;
import com.genesyslab.platform.applicationblocks.com.objects.CfgAgentInfo;
import com.genesyslab.platform.applicationblocks.com.objects.CfgAgentLoginInfo;
import com.genesyslab.platform.applicationblocks.com.objects.CfgPerson;
import com.genesyslab.platform.applicationblocks.com.queries.CfgAgentGroupQuery;
import com.genesyslab.platform.configuration.protocol.types.CfgFlag;
import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.AgentGroup;
import com.shuratech.gis.api.model.AgentLogin;
import com.shuratech.gis.impl.genesys.utils.GenesysUtils;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class ServcieImp {
	protected ConfService userConfService;
	public ServcieImp(ConfService userConfService) {
		this.userConfService = userConfService;
	}
	protected Agent mapAgentGenesysObject(CfgPerson person) {
		Agent agent = new Agent();
		agent.setEmail(person.getEmailAddress());
		agent.setEmployeeID(person.getEmployeeID());
		agent.setFirstName(person.getFirstName());
		CfgAgentInfo agentLogins = person.getAgentInfo();
		if (agentLogins.getAgentLogins() != null) {
			Iterator<CfgAgentLoginInfo> logins = agentLogins.getAgentLogins()
					.iterator();
			while (logins.hasNext()) {
				CfgAgentLoginInfo info = logins.next();
				String shortCode = info.getAgentLogin().getLoginCode();
				int dbID = info.getAgentLogin().getDBID();
				int switchDBID = info.getAgentLogin().getSwitchDBID();
				AgentLogin logins2 = new AgentLogin();
				logins2.setSwitchID(switchDBID);
				logins2.setDbID(dbID);
				logins2.setLoginCode(shortCode);

				agent.getLoginIDs().add(logins2);
			}
		}
//		Collection<CfgSkillLevel> skilllevels = agentLogins.getSkillLevels();
//		if (skilllevels != null) {
//			Iterator<CfgSkillLevel> iterator = skilllevels.iterator();
//			while (iterator.hasNext()) {
//				CfgSkillLevel level = iterator.next();
//				int levels = level.getLevel();
//				String skillName = level.getSkill().getName();
//				Skill skill = new Skill();
//				skill.setName(skillName);
//				skill.setLevel(SkillLevel.valueOf(level + ""));
//				agent.getSkills().add(skill);
//			}
//
//		}
//		ArrayList<CfgAgentGroup> groups = getAgentGroup(person.getDBID(),false);
//		if (groups != null)
//			for (CfgAgentGroup group : groups) {
//				AgentGroup temp = new AgentGroup();
//				temp.setName(group.getGroupInfo().getName());
//				agent.getGroups().add(temp);
//			}
		return agent;
	}
	protected CfgPerson mapAgentObject(Agent agent) {
		CfgPerson cfgPerson = new CfgPerson(userConfService);
		cfgPerson.setFirstName(agent.getFirstName());
		cfgPerson.setLastName(agent.getLastName());
		cfgPerson.setPassword(agent.getCredential().getPassword());
		cfgPerson.setUserName(agent.getCredential().getUsername());
		cfgPerson.setChangePasswordOnNextLogin(CfgFlag.CFGTrue);
//		cfgPerson.setEmailAddress(agent.getEmail());
		cfgPerson.setEmployeeID(agent.getEmployeeID());
		cfgPerson.setIsAgent(CfgFlag.CFGTrue);
		return cfgPerson;
	}
	protected ArrayList<CfgAgentGroup> getAgentGroup(int dbid,boolean closeConn) {
		ArrayList<CfgAgentGroup> groups = new ArrayList<CfgAgentGroup>();
		try {
			CfgAgentGroupQuery query = new CfgAgentGroupQuery(userConfService);
			query.setPersonDbid(dbid);

			GenesysUtils.openIfClosed(userConfService);
			groups.addAll(query.execute());

		} catch (Exception ex) {

		} finally {
			if(closeConn)GenesysUtils.closeIfOpened(userConfService);
		}
		return groups;
	}
	protected AgentGroup mapGenesysOpject(CfgAgentGroup group) {
		AgentGroup agentGroup=new AgentGroup();
		agentGroup.setName(group.getGroupInfo().getName());
                agentGroup.setId(new Long(group.getGroupInfo().getDBID()));
//		ArrayList<CfgPerson> arrayList=new ArrayList<>(group.getAgents());
//		for(CfgPerson  person :arrayList){
//			agentGroup.getAgents().add(mapAgentGenesysObject(person));
//		}
		return agentGroup;
	}

}
