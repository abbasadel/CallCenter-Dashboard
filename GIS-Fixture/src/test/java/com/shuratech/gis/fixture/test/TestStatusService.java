package com.shuratech.gis.fixture.test;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.AgentStatus;
import com.shuratech.gis.api.model.AgentStatusUpdate;
import com.shuratech.gis.fixture.StatusServiceFixture;

public class TestStatusService {

    StatusServiceFixture statusFixture;

    @Test
    public void testgetAll() {
        statusFixture = new StatusServiceFixture();
        List<AgentStatus> status = statusFixture.getAll();
        Assert.assertNotNull("It shouldn't be null", status);
        System.out.println(status.toString());
    }

    @Test
    public void testGet() {
        statusFixture = new StatusServiceFixture();
        AgentStatusUpdate agentStatus = statusFixture.get(new Agent());
        Assert.assertNotNull("It shouldn't be null", agentStatus);
        System.out.println(agentStatus.toString());
    }

}
