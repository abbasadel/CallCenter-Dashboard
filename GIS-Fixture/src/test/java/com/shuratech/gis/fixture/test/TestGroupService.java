package com.shuratech.gis.fixture.test;


import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.AgentGroup;
import com.shuratech.gis.fixture.GroupServiceFixture;

public class TestGroupService {

	GroupServiceFixture group;
	
	// test of 	public List<AgentGroup> getAll() 
	@Test
	public void testGetAll(){
		group = new GroupServiceFixture();
		List<AgentGroup> agents= group.getAll();
		Assert.assertNotNull(agents);
	}
	
	
	//test of public AgentGroup get(final String id) 
	@Test
	public void testGet(){
		group = new GroupServiceFixture();
		Long id = 10L;
		AgentGroup agentGroup = group.get(id);
		Assert.assertTrue("there is no Match",agentGroup.getId().equals(id));
	}
	
	// test of public AgentGroup create(AgentGroup t) 
//	@Test
//	public void testCreate(){
//		group = new GroupServiceFixture();
//		AgentGroup agentGroup = group.create(new AgentGroup());
//		Assert.assertNotNull(agentGroup);
//	}
//	
//	//test of public AgentGroup update(AgentGroup t)
//	@Test
//	public void testUpdate(){
//		group = new GroupServiceFixture();
//		AgentGroup agentGroup = group.update(new AgentGroup());
//		Assert.assertNotNull(agentGroup);
//	}
//	
//	//test of 	public boolean delete(String id)
//	@Test
//	public void testDelete(){
//		group = new GroupServiceFixture();
//		boolean result = group.delete(1L);
//		Assert.assertTrue(result);
//	}
//	
//	//test of 	public boolean add(Agent agent, AgentGroup group)
//	@Test
//	public void TestAdd(){
//		group=new GroupServiceFixture();
//		boolean result = group.add(new Agent(), new AgentGroup());
//		Assert.assertTrue(result);
//	}
//	
//	//test of 	public boolean add(List<Agent> agents, AgentGroup group) 
//	@Test
//	public void testAddList(){
//		group = new GroupServiceFixture();
//		boolean result = group.add(new ArrayList<Agent>(), new AgentGroup());
//		Assert.assertTrue(result);
//	}
//	
//	// test of public boolean remove(Agent agent, AgentGroup group)
//	@Test
//	public void testRemove(){
//		group = new GroupServiceFixture();
//		boolean result = group.remove(new Agent(), new AgentGroup());
//		Assert.assertTrue(result);
//	}
//
//
//	// test of 	public boolean remove(List<Agent> agents, AgentGroup group)
//	@Test
//	public void testRemoveList(){
//		group = new GroupServiceFixture();
//		boolean result= group.remove(new ArrayList<Agent>(), new AgentGroup());
//		Assert.assertTrue(result);
//	}
}
