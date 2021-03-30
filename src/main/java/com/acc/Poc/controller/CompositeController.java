package com.acc.Poc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acc.Poc.dtos.salesforceObj;

@RestController
public class CompositeController {
	
	
	@PostMapping("/sfObj")
	public void executeComposite(@RequestBody salesforceObj obj ) {
		
		System.out.println(obj);
		System.out.println("jvghv");
		
		
	}

}
