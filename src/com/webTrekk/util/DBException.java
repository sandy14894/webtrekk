package com.webTrekk.util;


public class DBException extends Exception {
	
	private String message;

	public DBException() {
		super();
	}

	public DBException(String message) {
		super(message);
		this.message = message;
	}

	public DBException(Exception e) {
		super(e);

	}

	public DBException(String message, Exception e) {
		super(message, e);

	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
