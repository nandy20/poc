package com.acc.Poc.serviceImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.acc.Poc.dtos.GenericApiRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class ProcessCompositeApi {
	
	public void process(String filePath) {
		
		JSONArray js=jsonConverter(filePath);	
		List<GenericApiRequest> genericApiRequests = getGenericApiRequests(js);	
	}
	
	private List<GenericApiRequest> getGenericApiRequests(JSONArray js){
		List<GenericApiRequest> list = new ArrayList<GenericApiRequest>();
		for(Object obj : js) {
			JSONObject jsonObject = (JSONObject)obj;
			System.out.println(jsonObject);
			
			
			try {
				Gson gson = new Gson();
			     GenericApiRequest genericApi = gson.fromJson(jsonObject.toString(), GenericApiRequest.class);
			     list.add(genericApi);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return list;
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
