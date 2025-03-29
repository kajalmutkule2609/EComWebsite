package org.techhub.eComWebsite.exceptions;

public class UserNotFoundException extends Exception {
	String message;
	public UserNotFoundException(String message){
		this.message=message;
	}
	public String userException(String message) {
		return message;
	}

}
