package com.shuratech.gis.impl.genesys.service;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.shuratech.gis.api.exceptions.GISGeneralExceptions;
import com.shuratech.gis.api.exceptions.UserNotFoundException;
import com.shuratech.gis.api.model.User;

public class ServiceLocatorTest {

    static User user = new User();
    public static ServiceLocator locator = null;

    @Before
    public void setUp() throws Exception {
        Properties prop = new Properties();
        prop.setProperty("CFG.PORT", "2020");
        prop.setProperty("CFG.HOST", "192.168.0.98");
        prop.setProperty("CFG.APP_NAME", "default");
        prop.setProperty("STAT_HOST", "192.168.0.98");
        prop.setProperty("STAT_PORT", "7004");
        ServiceLocator.initServiceLocator(prop);

        prop.save(new FileOutputStream("Shura.properties"), "Shura Solutions");

        user.setPassword("123456");
        user.setUsername("Adel");

    }

   
    @Test
    public void testGetServiceLocatorInstance() {
        try {

            locator = ServiceLocator.getServiceLocatorInstance(user);
            assertNotNull(locator);

        } catch (Exception e) {
            fail(e.getMessage());

        }
    }


}
