package com.acc.Poc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.Poc.dtos.salesforceObj;
import com.acc.Poc.enums.CompositeFileSelectorEnum;

@Service
public class ExecuteCompositeApi {
	
	@Autowired
	ProcessCompositeApi processApi;

	public void run(salesforceObj obj) {	
		processApi.process(obj);
	}
}
