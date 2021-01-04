package com.blz.onlineclaimregistartion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {

	private int status;
	private String message;
	private Object data;
	private int statusCode;

	public ResponseDTO(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public ResponseDTO(int statusCode, String message, Object token) {
		this.message = message;
		this.data = token;
		this.statusCode = statusCode;
	}
}
