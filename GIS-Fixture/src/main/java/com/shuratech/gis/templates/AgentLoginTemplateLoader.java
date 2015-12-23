package com.shuratech.gis.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import com.shuratech.gis.api.model.AgentLogin;


public class AgentLoginTemplateLoader implements TemplateLoader {

	public void load(){
		Fixture.of(AgentLogin.class).addTemplate("login", new Rule(){{
			add("loginCode", random("a1","a2","a3","a4","a6"));
			add("dbID", random(101,102,103,104,105,106));
			add("switchID", random(100,110,120,130,140,150));
		}});
	}
}
