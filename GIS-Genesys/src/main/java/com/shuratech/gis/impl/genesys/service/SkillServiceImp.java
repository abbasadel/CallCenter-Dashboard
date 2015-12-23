package com.shuratech.gis.impl.genesys.service;

import java.util.ArrayList;
import java.util.List;
import com.genesyslab.platform.applicationblocks.com.ConfService;
import com.genesyslab.platform.applicationblocks.com.ConfigException;
import com.genesyslab.platform.applicationblocks.com.objects.CfgPerson;
import com.genesyslab.platform.applicationblocks.com.objects.CfgSkill;
import com.genesyslab.platform.applicationblocks.com.objects.CfgSkillLevel;
import com.genesyslab.platform.applicationblocks.com.queries.CfgPersonQuery;
import com.genesyslab.platform.applicationblocks.com.queries.CfgSkillQuery;
import com.genesyslab.platform.applicationblocks.com.runtime.factory.CfgSkillLevelFactory;
import com.shuratech.gis.api.exceptions.GISGeneralExceptions;
import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.Skill;
import com.shuratech.gis.api.model.SkillLevel;
import com.shuratech.gis.api.service.SkillService;
import com.shuratech.gis.impl.genesys.utils.GenesysUtils;

public class SkillServiceImp extends ServcieImp implements SkillService {

    public SkillServiceImp(ConfService userConfService) {
        super(userConfService);
    }

    @Override
    public List<Skill> getAll() {
        ArrayList<Skill> list = new ArrayList<Skill>();
        CfgSkillQuery query = new CfgSkillQuery(userConfService);
        try {
            GenesysUtils.openIfClosed(userConfService);
            ArrayList<CfgSkill> cfgSkills = new ArrayList<CfgSkill>(query.execute());
            GenesysUtils.closeIfOpened(userConfService);
            for (CfgSkill skill : cfgSkills) {
                String name = skill.getName();

                Skill sk = new Skill();
                sk.setName(name);

                list.add(sk);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new GISGeneralExceptions();
        }

        return list;
    }

    @Override
    public Skill get(Long id) {
        Skill sk = new Skill();
        CfgSkillQuery query = new CfgSkillQuery(userConfService);
        long idlong = id;
        query.setDbid((int) idlong);
        try {
            GenesysUtils.openIfClosed(userConfService);
            CfgSkill skill = query.executeSingleResult();
            GenesysUtils.closeIfOpened(userConfService);
            String name = skill.getName();

            sk.setName(name);

        } catch (ConfigException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new GISGeneralExceptions();
        }

        return sk;
    }

    @Override
    public Skill create(Skill t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Skill update(Skill t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean delete(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Skill> getAll(Agent agent) {
        // TODO Auto-generated method stub
        return getEnabled(agent);
    }

    @Override
    public List<Skill> getEnabled(Agent agent) {
        ArrayList<Skill> list = new ArrayList<Skill>();
        CfgPersonQuery query = new CfgPersonQuery(userConfService);
        try {
            GenesysUtils.openIfClosed(userConfService);
            query.setEmployeeId(agent.getEmployeeID());
            CfgPerson person = query.executeSingleResult();
            System.out.println(person.getFirstName());
            ArrayList<CfgSkillLevel> skillLevels = new ArrayList<CfgSkillLevel>(person.getAgentInfo().getSkillLevels());
            System.out.println(skillLevels.size());
            for (CfgSkillLevel level : skillLevels) {

                Skill skill = new Skill();
                skill.setName(level.getSkill().getName());
                skill.setLevel(SkillLevel.getByValue(level.getLevel()));
                list.add(skill);
            }
            GenesysUtils.closeIfOpened(userConfService);
        } catch (Exception ex) {

        }
        return list;
    }

    @Override
    public List<Skill> getDisbaled(Agent agent) {

        return null;
    }

    @Override
    public boolean clearDisabled(Agent agent) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addSkill(Agent agent, Skill skill, SkillLevel level) {
        GenesysUtils.openIfClosed(userConfService);
        CfgPersonQuery personQuery = new CfgPersonQuery(userConfService);
        personQuery.setEmployeeId(agent.getEmployeeID());
        CfgSkillQuery skillQuery = new CfgSkillQuery(userConfService);
        skillQuery.setName(skill.getName());

        try {
            CfgPerson person = personQuery.executeSingleResult();
            CfgSkill skill2 = skillQuery.executeSingleResult();
            CfgSkillLevel skillLevel = new CfgSkillLevel(userConfService, person);
            skillLevel.setSkill(skill2);
            switch (level) {
                case High:
                    skillLevel.setLevel(10);
                    break;
                case Medium:
                    skillLevel.setLevel(20);
                    break;
                case Low:
                    skillLevel.setLevel(30);
                    break;

                default:
                    skillLevel.setLevel(30);
                    break;
            }
            //	skillLevel.setLevel(10);
            person.getAgentInfo().getSkillLevels().add(skillLevel);
            person.save();
        } catch (ConfigException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean removeSkill(Agent agent, Skill skill) {
        GenesysUtils.openIfClosed(userConfService);
        CfgPersonQuery personQuery = new CfgPersonQuery(userConfService);
        personQuery.setEmployeeId(agent.getEmployeeID());
        CfgSkillQuery skillQuery = new CfgSkillQuery(userConfService);
        skillQuery.setName(skill.getName());

        try {
            CfgPerson person = personQuery.executeSingleResult();
            CfgSkill skill2 = skillQuery.executeSingleResult();

            CfgSkillLevel skillLevel = new CfgSkillLevel(userConfService, person);
            skillLevel.setSkill(skill2);
            ArrayList<CfgSkillLevel> levels = new ArrayList<CfgSkillLevel>(person.getAgentInfo().getSkillLevels());
            ArrayList<CfgSkillLevel> newList = new ArrayList<CfgSkillLevel>();
            for (CfgSkillLevel level : levels) {
                if (level.getSkill().getDBID() != skill2.getDBID()) {
                    newList.add(level);
                }
            }
            GenesysUtils.openIfClosed(userConfService);
            person.getAgentInfo().setSkillLevels(newList);
            person.save();
        } catch (ConfigException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean addSkill(Agent agent, Skill skill) {

        return addSkill(agent, skill, SkillLevel.Low);
    }

    @Override
    public Skill getSkillByName(String skillname) {
        Skill sk = new Skill();
        CfgSkillQuery query = new CfgSkillQuery(userConfService);

        query.setName(skillname);
        try {
            GenesysUtils.openIfClosed(userConfService);
            CfgSkill skill = query.executeSingleResult();
            GenesysUtils.closeIfOpened(userConfService);
            String name = skill.getName();

            sk.setName(name);

        } catch (ConfigException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new GISGeneralExceptions();
        }

        return sk;
    }

}
