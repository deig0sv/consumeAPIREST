package com.consumeApiRest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

	@JsonProperty("id")
	private int id;
	
	@JsonProperty("product_name")
	private String productName;
	
	@JsonProperty("product_version")
	private String productVersion;
	
	@JsonProperty("activate_code")
	private String activateCode;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("check_sum_MAC")
	private String checkSumMAC;
	
	@JsonProperty("comments")
	private String comments;

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductVersion() {
		return productVersion;
	}
	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}
	public String getActivateCode() {
		return activateCode;
	}
	public void setActivateCode(String activateCode) {
		this.activateCode = activateCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCheckSumMAC() {
		return checkSumMAC;
	}
	public void setCheckSumMAC(String checkSumMAC) {
		this.checkSumMAC = checkSumMAC;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	@Override
	public String toString(){
		return "[id="+id+", activate_code="+activateCode+", product_name="+productName
				+ ", product_version="+productVersion+ ", state="+state+", check_sum_MAC="+checkSumMAC
				+ ", comments="+comments+ "]";
	}
	
}
