package com.shuratech.gis.impl.genesys.service;

import java.util.Properties;

import com.genesyslab.platform.applicationblocks.com.ConfService;
import com.genesyslab.platform.applicationblocks.com.ConfServiceFactory;
import com.genesyslab.platform.commons.protocol.Endpoint;
import com.genesyslab.platform.commons.protocol.ProtocolException;
import com.genesyslab.platform.commons.protocol.RegistrationException;
import com.genesyslab.platform.configuration.protocol.ConfServerProtocol;
import com.shuratech.gis.api.exceptions.GISGeneralExceptions;
import com.shuratech.gis.api.exceptions.UserNotFoundException;
import com.shuratech.gis.api.model.User;
import com.shuratech.gis.api.service.AgentService;
import com.shuratech.gis.api.service.AgentStatusService;
import com.shuratech.gis.api.service.GroupService;
import com.shuratech.gis.api.service.SkillService;
import com.shuratech.gis.impl.genesys.utils.GenesysUtils;

public class ServiceLocator {

    /**
     * @author Mohamed ELFayomy
     *
     *
     */
    private static Properties configrationFile;
    private AgentStatusService agentStatus = null;
    private AgentService agentService = null;
    private GroupService groupService = null;
    private SkillService skillService = null;
    private ConfService userConfService;
	//private 

    /**
     * This Method will be called once while initiating Context Listener you
     * will provide the Service Locater class with properties file new
     * Properties
     * ().load(servletConext().getRealPath("/WEB-INF/Configration.properties"))
	 *
     */
    public static void initServiceLocator(Properties configrationFile) {
        ServiceLocator.configrationFile = configrationFile;
    }

    public static String getProperty(String key) throws GISGeneralExceptions {
        if (configrationFile == null) {
            throw new GISGeneralExceptions("No Configration file Exist");
        }
        String value = configrationFile.getProperty(key);
        if (value == null) {
            throw new GISGeneralExceptions("Missing Key:" + key + " in configration file");
        }

        return value;
    }

    /**
     * Cash the returned object in user session if you get it.
     * UserNotFoundException : For User to indecate 
 *
     */
    public static ServiceLocator getServiceLocatorInstance(User user) throws UserNotFoundException, GISGeneralExceptions {
        if (user != null) {
            ConfService userConfService = GenesysUtils.getuserConfService(user);
            try {
                userConfService.getProtocol().open();
                userConfService.getProtocol().close();
            } catch (Exception e) {
                //e.printStackTrace();
                if (e instanceof RegistrationException) {
                    throw new UserNotFoundException("user name or password is incorrect");
                } else {
                    throw new GISGeneralExceptions("Technical Error", e);
                }

            }
            return new ServiceLocator(userConfService);
        } else {
            throw new UserNotFoundException("Invalid UserName Or Password");
        }
    }

    private ServiceLocator(ConfService userConfService) {
        this.userConfService = userConfService;
        agentService = new AgentServiceImp(userConfService);
        groupService = new GroupServiceImp(userConfService);
        agentStatus = new AgentStatusServiceImp(userConfService);
        skillService = new SkillServiceImp(userConfService);
    }

    public AgentStatusService getAgentStatus() {
        return agentStatus;
    }

    public void setAgentStatus(AgentStatusService agentStatus) {
        this.agentStatus = agentStatus;
    }

    public AgentService getAgentService() {
        return agentService;
    }

    public void setAgentService(AgentService agentService) {
        this.agentService = agentService;
    }

    public GroupService getGroupService() {
        return groupService;
    }

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    public SkillService getSkillService() {
        return skillService;
    }

    public void setSkillService(SkillService skillService) {
        this.skillService = skillService;
    }

    protected ConfService getUserConfService() {
        return userConfService;
    }

    public void destroy() {
        setAgentService(null);
        setAgentStatus(null);
        setGroupService(null);
        setSkillService(null);
        GenesysUtils.closeIfOpened(userConfService);

    }

}
