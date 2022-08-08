package com.exceptions;

public class InvalidSeatNumberException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 134929948051292154L;
	public InvalidSeatNumberException(String exceptionMessage){
		super(exceptionMessage);
	}
}
