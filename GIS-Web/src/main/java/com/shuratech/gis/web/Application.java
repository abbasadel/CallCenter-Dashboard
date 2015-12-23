package com.shuratech.gis.web;

import com.shuratech.gis.api.model.User;
import com.shuratech.gis.api.service.AgentService;
import com.shuratech.gis.api.service.AgentStatusService;
import com.shuratech.gis.api.service.AuthService;
import com.shuratech.gis.api.service.GroupService;
import com.shuratech.gis.api.service.SkillService;
import com.shuratech.gis.fixture.AgentServiceFixture;
import com.shuratech.gis.fixture.GroupServiceFixture;
import com.shuratech.gis.fixture.SkillServiceFixture;
import com.shuratech.gis.fixture.StatusServiceFixture;
import com.shuratech.gis.impl.genesys.service.AuthServiceImpl;
import com.shuratech.gis.impl.genesys.service.ServiceLocator;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    static final boolean useFixture = true;

    static User user = new User();
    static ServiceLocator locator = null;

    static {
        if (!useFixture) {
            initGenesys();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public GroupService getGroupService() {
        return useFixture ? new GroupServiceFixture() : locator.getGroupService();
    }

    @Bean
    public AgentService getAgentService() {
        return useFixture ? new AgentServiceFixture() : locator.getAgentService();
    }

    @Bean
    AgentStatusService getAgentStatusService() {
        return useFixture ? new StatusServiceFixture() : locator.getAgentStatus();
    }
    
    @Bean
    SkillService getSkillService() {
        return useFixture ? new SkillServiceFixture() : locator.getSkillService();
    }
    
    @Bean
    AuthService getAuthService(){
        return new AuthServiceImpl();
    }

    private static void initGenesys() {
        Properties prop = new Properties();
        prop.setProperty("CFG.PORT", "2020");
        prop.setProperty("CFG.HOST", "192.168.0.33");
        prop.setProperty("CFG.APP_NAME", "default");
        prop.setProperty("STAT_HOST", "192.168.0.33");
        prop.setProperty("STAT_PORT", "7004");
        prop.setProperty("STAT_SERVER", "Stat_Server");
        ServiceLocator.initServiceLocator(prop);
        try{
        FileOutputStream fout = new FileOutputStream("D:\\configuration.properties");
        ObjectOutputStream outObject = new ObjectOutputStream(fout);
        outObject.writeObject(prop);
        outObject.close();
        System.out.println("done");
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        user.setPassword("password");
        user.setUsername("default");
        try {
            locator = ServiceLocator.getServiceLocatorInstance(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
