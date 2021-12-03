package com.olx.masterdata.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class InvalidAuthTokenException extends RuntimeException {
	private String message;

	public InvalidAuthTokenException() {
		this.message = "";
	}
	public InvalidAuthTokenException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "Invalid Stock Id" + this.message ;
	}
	

}
