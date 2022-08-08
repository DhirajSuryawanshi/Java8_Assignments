package com.exceptions;

public class SeatNotAvailableException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3216128734413616215L;
	public SeatNotAvailableException(String exceptionmessage) {
		super(exceptionmessage);
	}
}
