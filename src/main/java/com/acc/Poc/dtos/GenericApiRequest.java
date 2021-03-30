package com.acc.Poc.dtos;

import java.util.List;

public class GenericApiRequest {
	  private ApiRequestConfig apiRequest;
	  private List<String> onSuccess;
	  private List<String> onFailure;
	  private String retry;
	  private String apiKey;
	public ApiRequestConfig getApiRequest() {
		return apiRequest;
	}
	public void setApiRequest(ApiRequestConfig apiRequest) {
		this.apiRequest = apiRequest;
	}
	public List<String> getOnSuccess() {
		return onSuccess;
	}
	public void setOnSuccess(List<String> onSuccess) {
		this.onSuccess = onSuccess;
	}
	public List<String> getOnFailure() {
		return onFailure;
	}
	public void setOnFailure(List<String> onFailure) {
		this.onFailure = onFailure;
	}
	public String getRetry() {
		return retry;
	}
	public void setRetry(String retry) {
		this.retry = retry;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	@Override
	public String toString() {
		return "GenericApiRequest [apiRequest=" + apiRequest + ", onSuccess=" + onSuccess + ", onFailure=" + onFailure
				+ ", retry=" + retry + ", apiKey=" + apiKey + "]";
	}
	  
	  
	}
