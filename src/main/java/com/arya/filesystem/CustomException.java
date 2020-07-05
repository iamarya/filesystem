package com.arya.filesystem;

/**
 * @author arya
 * 
 * This is a custom exception class for handling exception
 */
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomException(String msg, Exception e) {
		super(msg, e);
	}
}
