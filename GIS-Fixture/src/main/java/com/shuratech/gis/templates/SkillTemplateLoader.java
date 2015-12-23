package com.shuratech.gis.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import com.shuratech.gis.api.model.Skill;

public class SkillTemplateLoader implements TemplateLoader {
	@Override
	public void load() {
		// TODO Auto-generated method stub
		Fixture.of(Skill.class).addTemplate("skill", new Rule(){{
			add("name", random("english","german","italic","communication skills"));
		}});
		
	}
}
