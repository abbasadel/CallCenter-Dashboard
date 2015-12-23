package com.shuratech.gis.web.response;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class JsonResponse implements Serializable {

	private static final long serialVersionUID = -6068183407884308855L;

	HttpStatus staus = HttpStatus.OK;
	String message;

	public JsonResponse() {
		super();
	}

	public JsonResponse(HttpStatus staus, String message) {
		super();
		this.staus = staus;
		this.message = message;
	}

	public JsonResponse(String message) {
		super();
		this.message = message;
	}

	public HttpStatus getStaus() {
		return staus;
	}

	public void setStaus(HttpStatus staus) {
		this.staus = staus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static JsonResponse make(String msg) {
		return new JsonResponse(msg);
	}
	
	public static JsonResponse make(String msg, HttpStatus status) {
		return new JsonResponse(status, msg);
	}
	
	

}
