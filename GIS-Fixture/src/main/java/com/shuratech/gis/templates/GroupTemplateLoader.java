package com.shuratech.gis.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import com.shuratech.gis.api.model.AgentGroup;

public class GroupTemplateLoader implements TemplateLoader {
	@Override
	public void load() {
		// TODO Auto-generated method stub
		Fixture.of(AgentGroup.class).addTemplate("group", new Rule(){{
			add("id", random(Long.class, range(1L, 200L)));
			add("name", random("customer Service","ADSL Service","Marketing","Technical Support"));
		}});
		
	}

}
