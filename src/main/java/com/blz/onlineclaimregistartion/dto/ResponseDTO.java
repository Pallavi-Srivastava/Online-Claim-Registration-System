package com.blz.onlineclaimregistartion.dto;

import lombok.Data;

@Data
public class ResponseDTO {
	private String message;
	private Object data;
	private int statusCode;
	
	public ResponseDTO(String message) {
		this.message = message;
	} 

	public ResponseDTO(String message, Object data) {
		this.message = message;
		this.data = data;
	}
	
	public ResponseDTO(int statusCode, String message, Object token) {
		this.message = message;
		this.data = token;
		this.statusCode=statusCode;
	}
}
