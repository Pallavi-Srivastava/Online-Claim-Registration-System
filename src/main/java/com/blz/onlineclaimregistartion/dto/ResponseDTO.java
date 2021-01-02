package com.blz.onlineclaimregistartion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor 
public class ResponseDTO {
	
	private int status;
	private String message;
	private Object data;
	
	public ResponseDTO(int status, String message) {
		this.status = status;
		this.message = message;
	}
	
}
