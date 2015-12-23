package com.shuratech.gis.fixture.test;

import org.junit.Test;

import com.shuratech.gis.api.model.Agent;
import com.shuratech.gis.api.model.AgentGroup;
import com.shuratech.gis.fixture.StatusServiceFixture;

public class TestDateEnumFunction {

	@Test
	public void testGenerateDate(){
//		DateEnumFunction dateEnumFunction = new DateEnumFunction();
//		RandomFunction random = new RandomFunction(Long.class,new Range(new Date().getTime(), new Date().getTime()-1000));\
//		Calendar al = Calendar.getInstance();
//		Calendar al2 = Calendar.getInstance();
//		al.add(Calendar.SECOND, -3000);
//		
//		DateTimeFunction dateTimeFunction = new DateTimeFunction(al,al2);
//		dateTimeFunction.generateValue();
//		System.out.println(dateTimeFunction.generateValue());
//		System.out.println("range start: "+al);
//		System.out.println("range start: "+al2);
//		
//		System.out.println(DateFormatUtils.format(al2, "yyyy/MM/dd HH:mm:ss"));
//		System.out.println(DateFormatUtils.format(al, "yyyy/MM/dd HH:mm:ss"));
//
//		System.out.println(DateFormatUtils.format((Calendar)dateTimeFunction.generateValue(), "yyyy/MM/dd HH:mm:ss"));
//		System.out.println(DateFormatUtils.format((Calendar)dateTimeFunction.generateValue(), "yyyy/MM/dd HH:mm:ss"));
//

		StatusServiceFixture statusServiceFixture = new StatusServiceFixture();
		AgentGroup agentGroup = new AgentGroup();
		statusServiceFixture.get(agentGroup);
	}
	
	
}
