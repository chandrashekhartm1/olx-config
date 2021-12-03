package com.olx.masterdata.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class InvalidRecordNoException extends RuntimeException {
	private String message;

	public InvalidRecordNoException() {
		this.message = "";
	}
	public InvalidRecordNoException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "Invalid Stock Id" + this.message ;
	}
	

}
