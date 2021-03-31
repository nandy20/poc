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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class ProcessCompositeApi {
	
	String username = "jayaram@accolitedigital.com";
	String password = "Accolite@123Ljmq16LqC8ndmxau4fTKLhsQS";
	
	public void process(String filePath) {
		
		JSONArray js=jsonConverter(filePath);	
		List<GenericApiRequest> genericApiRequests = getGenericApiRequests(js);	
	}
	
	private List<GenericApiRequest> getGenericApiRequests(JSONArray js){
		List<GenericApiRequest> list = new ArrayList<GenericApiRequest>();
		for(Object obj : js) {
			JSONObject jsonObject = (JSONObject)obj;
			JSONObject processedApi = processEachApi(jsonObject);
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
	
	private JSONObject processEachApi(JSONObject object) {
		switch ((String)object.get("apiKey")) {
		case "1":
			JSONObject object2 = (JSONObject) object.get("apiRequest");
			String object3 =(String) object2.get("requestBody");
			String string = object3.replace("$USERNAME", username);
			String string2 = string.replace("$PASSWORD", password);
			object2.put("requestBody", string2);
			return object2;
		default:
			break;
		}
		return object;
	}

}
