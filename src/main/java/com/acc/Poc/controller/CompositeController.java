package com.acc.Poc.controller;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acc.Poc.dtos.salesforceObj;
import com.acc.Poc.enums.CompositeFileSelectorEnum;

@RestController
public class CompositeController {
	
	
	@PostMapping("/sfObj")
	public void executeComposite(@RequestBody salesforceObj obj ) {
			String entityPath = CompositeFileSelectorEnum.getCompositeJson(obj.getEntityName());
			System.out.println(entityPath);
		
	}

}
