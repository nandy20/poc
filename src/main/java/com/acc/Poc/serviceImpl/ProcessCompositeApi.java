package com.acc.Poc.serviceImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.acc.Poc.dtos.GenericApiRequest;
import com.acc.Poc.dtos.salesforceObj;
import com.acc.Poc.enums.CompositeFileSelectorEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class ProcessCompositeApi {
	
	String username = "jayaram@accolitedigital.com";
	String password = "Accolite@123Ljmq16LqC8ndmxau4fTKLhsQS";
	
	public void process(salesforceObj obj) {
		String entityPath = CompositeFileSelectorEnum.getCompositeJson(obj);
		JSONArray js=jsonConverter(entityPath,"requestList");	
		List<GenericApiRequest> genericApiRequests = getGenericApiRequests(js,obj.getEntityName());	
	}
	
	private List<GenericApiRequest> getGenericApiRequests(JSONArray js,String entityName){
		List<GenericApiRequest> list = new ArrayList<GenericApiRequest>();
		for(Object obj : js) {
			JSONObject jsonObject = (JSONObject)obj;
			JSONObject processedApi = processEachApi(jsonObject,entityName);
			System.out.println(processedApi.toString());
			try {
				Gson gson = new Gson();
			    GenericApiRequest genericApi = gson.fromJson(processedApi.toString(), GenericApiRequest.class);
			     list.add(genericApi);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	private JSONArray jsonConverter(String filePath,String jsonField) {
		try {
			JSONParser jsonParser = new JSONParser();
		      FileReader reader = new FileReader(filePath);
		      JSONObject configJson = (JSONObject) jsonParser.parse(reader);
		      JSONArray requestListJson = (JSONArray) configJson.get(jsonField);
		      System.out.println(requestListJson);
		      return requestListJson;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	private JSONObject processEachApi(JSONObject object,String entityName) {
		JSONObject object2 = (JSONObject) object.get("apiRequest");
		String object3 =(String) object2.get("requestBody");
		switch ((String)object.get("apiKey")) {
		case "1":
			String string = object3.replace("$USERNAME", username);
			String string2 = string.replace("$PASSWORD", password);
			object2.put("requestBody", string2);
			return object2;
		case "2":
			String string1=object3.replace("$ENTITY", entityName);
			object2.put("requestBody", string1);
			return object2;
		case "3":
			
			try {
				JSONParser jsonParser = new JSONParser();
			      FileReader reader = new FileReader("src\\main\\resources\\CompositeApiJsons\\compositeApi-queries.json");
			      JSONObject configJson = (JSONObject) jsonParser.parse(reader);
                  object2.put("requestBody",configJson.get(entityName));
                  return object2;
			} catch (Exception e) {
				e.printStackTrace();
			}
		default:
			break;
		}
		return object;
	}

}
