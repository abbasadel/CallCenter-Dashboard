package com.shuratech.gis.impl.genesys.service;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.shuratech.gis.api.exceptions.GISGeneralExceptions;
import com.shuratech.gis.api.exceptions.UserNotFoundException;
import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.AgentStatus;
import com.shuratech.gis.api.model.User;
import com.shuratech.gis.api.service.AgentService;
import org.junit.BeforeClass;

public class AgentServiceImpTest {

    static User user = new User();
    public static ServiceLocator locator = null;

    @BeforeClass
    public static void setUp() throws Exception {
        Properties prop = new Properties();
        prop.setProperty("CFG.PORT", "2020");
        prop.setProperty("CFG.HOST", "192.168.0.98");
        prop.setProperty("CFG.APP_NAME", "default");
        prop.setProperty("STAT_HOST", "192.168.0.98");
        prop.setProperty("STAT_PORT", "7004");
        ServiceLocator.initServiceLocator(prop);
        user.setPassword("password");
        user.setUsername("default");
        try {

            locator = ServiceLocator.getServiceLocatorInstance(user);
            assertNotNull(locator);

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }


   
    @Test
    public void testGetAll() {
        AgentService imp = locator
                .getAgentService();
        System.out.println(imp.getAll());
        //assertNotNull(imp);
        ServiceLocatorTest.locator.destroy();
    }

    @Test
    public void testGetAllIntInt() {
        fail("Not yet implemented");
    }

    @Test
    public void testGet() {
        AgentService imp = locator
                .getAgentService();
        System.out.println(imp.get("USR1"));
        //	ServiceLocatorTest.locator.destroy();
    }

    @Test
    public void testCreate() {
        Agent agent = new Agent();
        agent.setEmail("");
        agent.setEmployeeID("ALI");
        agent.setFirstName("ALI");
        agent.setLastName("ALI");
        User user = new User();
        user.setPassword("123456");
        user.setUsername("ALI");
        agent.setCredential(user);

        agent.setStatus(AgentStatus.LoggedOut);
        AgentService imp = locator
                .getAgentService();
        imp.create(agent);

    }

   

    @Test
    public void testDelete() {
        Agent agent = new Agent();
        agent.setEmail("");
        agent.setEmployeeID("ALI");
        agent.setFirstName("ALI");
        agent.setLastName("ALI");
        agent.setStatus(AgentStatus.LoggedOut);
        AgentService imp = locator
                .getAgentService();
        imp.delete("ALI");
    }

    
}
