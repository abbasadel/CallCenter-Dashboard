package com.shuratech.gis.fixture.test;

import junit.framework.Assert;

import org.junit.Test;

import com.shuratech.gis.fixture.InMemoDB;

public class TestInMemoryDB {

	@Test
	public void testMount(){
		Assert.assertNotNull("it can't be null",InMemoDB.groups);
		System.out.println(InMemoDB.groups);
	}
}
