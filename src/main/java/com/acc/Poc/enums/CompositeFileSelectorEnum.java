package com.acc.Poc.enums;

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
	
	public static  String getCompositeJson(String key) {
		for(CompositeFileSelectorEnum type:values()) {
			if(type.entity.equals(key)){
				return type.path;
			}
		}
		return null;
	}
	

}
