package com.blz.onlineclaimregistartion.dto;

import lombok.Data;

@Data
public class ResponseDTO {
	private int status;
	private long responseMessage;
	private String message;
	private Object data;

	public ResponseDTO(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public ResponseDTO(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}
	public ResponseDTO(int status, String message, Object data) {
		this.message = message;
		this.status = status;
		this.data = data;
	}

	public ResponseDTO(int status, long responseMessage) {

		this.status = status;
		this.responseMessage = responseMessage;
	}
	
}
