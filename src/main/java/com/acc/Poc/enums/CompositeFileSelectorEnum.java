package com.acc.Poc.enums;

import com.acc.Poc.dtos.salesforceObj;

public enum CompositeFileSelectorEnum {
	
	CONTACT("contact","src\\main\\resources\\CompositeApiJsons\\contact-compositeApi.json");
	
	private String entity;
	private String path;
	
	
	private CompositeFileSelectorEnum() {
	}

	private CompositeFileSelectorEnum(String entity, String path) {
		this.entity = entity;
		this.path = path;
	}
	
	public static  String getCompositeJson(salesforceObj key) {
		for(CompositeFileSelectorEnum type:values()) {
			if(type.entity.equals(key.getEntityName())){
				return type.path;
			}
		}
		return null;
	}
	

}
