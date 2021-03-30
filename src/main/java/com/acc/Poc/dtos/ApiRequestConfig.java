package com.acc.Poc.dtos;

import java.util.List;

public class ApiRequestConfig {
	 private String url;
	  private List<NameValuePair<String, String>> pathParams;
	  private List<NameValuePair<String, String>> requestParams;
	  private String requestType;
	  private String methodType;
	  private List<NameValuePair<String, String>> headers;
	  private Object requestBody;
	  private List<String> store;
	  private List<Handle> successHandlers;
	  private List<String> procKeyOnSuccess;
	  private List<String> procKeyOnFailure;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<NameValuePair<String, String>> getPathParams() {
		return pathParams;
	}
	public void setPathParams(List<NameValuePair<String, String>> pathParams) {
		this.pathParams = pathParams;
	}
	public List<NameValuePair<String, String>> getRequestParams() {
		return requestParams;
	}
	public void setRequestParams(List<NameValuePair<String, String>> requestParams) {
		this.requestParams = requestParams;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getMethodType() {
		return methodType;
	}
	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}
	public List<NameValuePair<String, String>> getHeaders() {
		return headers;
	}
	public void setHeaders(List<NameValuePair<String, String>> headers) {
		this.headers = headers;
	}
	public Object getRequestBody() {
		return requestBody;
	}
	public void setRequestBody(Object requestBody) {
		this.requestBody = requestBody;
	}
	public List<String> getStore() {
		return store;
	}
	public void setStore(List<String> store) {
		this.store = store;
	}
	public List<Handle> getSuccessHandlers() {
		return successHandlers;
	}
	public void setSuccessHandlers(List<Handle> successHandlers) {
		this.successHandlers = successHandlers;
	}
	public List<String> getProcKeyOnSuccess() {
		return procKeyOnSuccess;
	}
	public void setProcKeyOnSuccess(List<String> procKeyOnSuccess) {
		this.procKeyOnSuccess = procKeyOnSuccess;
	}
	public List<String> getProcKeyOnFailure() {
		return procKeyOnFailure;
	}
	public void setProcKeyOnFailure(List<String> procKeyOnFailure) {
		this.procKeyOnFailure = procKeyOnFailure;
	}
	@Override
	public String toString() {
		return "ApiRequestConfig [url=" + url + ", pathParams=" + pathParams + ", requestParams=" + requestParams
				+ ", requestType=" + requestType + ", methodType=" + methodType + ", headers=" + headers
				+ ", requestBody=" + requestBody + ", store=" + store + ", successHandlers=" + successHandlers
				+ ", procKeyOnSuccess=" + procKeyOnSuccess + ", procKeyOnFailure=" + procKeyOnFailure + "]";
	}
	  
	  
}
