package com.learning.demo.globalException;

public class UserResponseException extends RuntimeException {
 
	public UserResponseException(String message) {
		super(message);
	}

}
