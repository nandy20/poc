package com.acc.Poc.serviceImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

@Service
public class ProcessCompositeApi {
	
	public void process(String filePath) {
		
		JSONArray js=jsonConverter(filePath);
		
	}
	
	
	private JSONArray jsonConverter(String filePath) {
		
		 
		try {
			JSONParser jsonParser = new JSONParser();
		      FileReader reader = new FileReader(filePath);
		      JSONObject configJson = (JSONObject) jsonParser.parse(reader);
		      JSONArray requestListJson = (JSONArray) configJson.get("requestList");
		      System.out.println(requestListJson);
		      return requestListJson;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
		
		return null;
	}

}
