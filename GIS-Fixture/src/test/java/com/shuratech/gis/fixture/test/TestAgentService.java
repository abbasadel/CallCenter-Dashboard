package com.shuratech.gis.fixture.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.AgentGroup;
import com.shuratech.gis.fixture.AgentServiceFixture;


public class TestAgentService {

	AgentServiceFixture agentService;
		
	// test of "public Agent get(final Long id)" method
	@Test
	public void testGet(){
		agentService = new AgentServiceFixture();
		String id = "a6";
		Agent agent = agentService.get(id);
//		System.out.println(agent.getId().toString());
		Assert.assertNotNull("it shouldn't be null",agent);
	}
	
	// test of 	"public List<Agent> getAll()" method
	@Test
	public void testGetAll(){
		agentService = new AgentServiceFixture();
		List<Agent> agents = agentService.getAll();
//		System.out.println("email of element 3: ");
//		System.out.println(agents.get(3).getEmail());
//		System.out.println("email of element 4: ");
//		System.out.println(agents.get(4).getEmail());
		Assert.assertNotNull("it shouldn't be null",agents);
		Assert.assertTrue("not equal 5", agents.size() == 5);	
	}
	
	// test of 	"public List<Agent> getAll(final int start, int max)" method
	@Test
	public void testGetAllParams(){
		agentService = new AgentServiceFixture();
		String start = "a7" ; int max = 4;
		List<Agent> agents = agentService.getAll(start, max);
		Assert.assertNotNull("it shouldn't be null", agents);
		Assert.assertTrue(agents.size() == 4);
	}
	
	// test of 	"public Agent create(Agent t)" method
	@Test
	public void testCreate(){
		agentService = new AgentServiceFixture();
		Agent agent = agentService.create(new Agent());
		Assert.assertNotNull("it shouldn't be null",agent);
	}
	
	// test of 	"public Agent update(Agent t)" method
	@Test
	public void testUpdate(){
		agentService = new AgentServiceFixture();
		Agent agent = agentService.update(new Agent());
		Assert.assertNotNull(agent);
	}
	
	// test of 	"public boolean delete(final Long id)" method
	@Test
	public void testDelete(){
		agentService = new AgentServiceFixture();
		boolean result = agentService.delete(new String("a10"));
		Assert.assertTrue("It should be true", result);
	}
	
	// test of "public List<Agent> getAll(final AgentGroup group)" method
//	@Test
//	public void testGetAllGroup(){
//		agentService = new AgentServiceFixture();
//		AgentGroup group = new AgentGroup();
//		group.setName("customerService");
//		List<Agent> agents = agentService.getAll(group);
//		Assert.assertNotNull(agents);
//	}

}







