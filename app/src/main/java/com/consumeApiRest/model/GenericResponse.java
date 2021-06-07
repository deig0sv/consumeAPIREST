package com.consumeApiRest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericResponse {

	@JsonProperty("Mensaje")
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString(){
		return "[Mensaje: "+getMsg()+"]";
	}
	
}
