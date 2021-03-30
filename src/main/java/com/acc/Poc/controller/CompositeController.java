package com.acc.Poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acc.Poc.dtos.salesforceObj;
import com.acc.Poc.enums.CompositeFileSelectorEnum;
import com.acc.Poc.serviceImpl.ExecuteCompositeApi;

@RestController
public class CompositeController {
	
	@Autowired
	ExecuteCompositeApi executeApi;
	
	
	@PostMapping("/sfObj")
	public void executeComposite(@RequestBody salesforceObj obj ) {
			
		executeApi.run(obj.getEntityName());
	}

}
