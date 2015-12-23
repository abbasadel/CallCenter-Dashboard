package com.shuratech.gis.templates;

import java.util.ArrayList;
import java.util.List;

import br.com.six2six.fixturefactory.function.AtomicFunction;
import br.com.six2six.fixturefactory.function.RandomFunction;

import com.shuratech.gis.api.model.AgentStatus;

public class EnumFunction implements AtomicFunction {

	public Class<? extends Enum<AgentStatus>> clazz;
	public int quantity;
	
	public EnumFunction(Class<? extends Enum<AgentStatus>> clazz, int quantity) {
		this.clazz = clazz;
		this.quantity = quantity;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<AgentStatus> generateValue() {
		List<AgentStatus> results = new ArrayList<AgentStatus>();
		AtomicFunction function = new RandomFunction(clazz);
		for (int i = 0; i < quantity; i++) {
			results.add((AgentStatus) function.generateValue());
		}

		return results;
	}
	
}