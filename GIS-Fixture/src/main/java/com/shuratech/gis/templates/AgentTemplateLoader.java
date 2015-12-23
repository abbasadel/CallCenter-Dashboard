package com.shuratech.gis.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.AgentGroup;
import com.shuratech.gis.api.model.AgentLogin;
import com.shuratech.gis.api.model.AgentStatus;

/*
 	private Long id;
	private AgentStatus status;
	private String firstName;
    private String lastName;
    private String employeeID;
    private String email;
    private List<AgentLogins> loginID;  
    private AgentGroup group;
	private List<Skill> skills;
    private List<Skill> disabledSkills;
    private List<AgentGroup> groups;
 */

public class AgentTemplateLoader implements TemplateLoader {
	public void load() {
			Fixture.of(Agent.class).addTemplate("agent", new Rule(){{
//				add("id",random(Long.class,range(10L, 100L)));
				add("status", random(AgentStatus.class));
				add("firstName", firstName());
				add("lastName", lastName());
				add("employeeID", random("a1","a2","a3","a4","a5"));
				add("email", "${firstName}@yahoo.com");
				add("loginID", random("239090","43242","324123","092304","5435324","2342342"));
				add("groups", has(4).of(AgentGroup.class, "group"));
			}});
	}		
}
