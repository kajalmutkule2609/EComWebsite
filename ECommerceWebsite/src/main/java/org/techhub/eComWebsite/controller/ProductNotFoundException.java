package org.techhub.eComWebsite.controller;

public class ProductNotFoundException extends Exception {
	
	String message;
	public ProductNotFoundException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
}
