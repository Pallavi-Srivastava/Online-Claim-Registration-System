package com.blz.onlineclaimregistartion.enums;

public enum UserRoleEnum {

	USER("user"),
	AGENT("agent"),
	ADMIN("admin");
	
	private String userRole;

	UserRoleEnum(String userRole) {
		this.userRole = userRole;
	}
	
	public String getUserRole() {
		return userRole;
	}
}
