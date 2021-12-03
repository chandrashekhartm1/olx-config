package com.olx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class NoAdvertiseFoundException extends RuntimeException {
	private String message;

	public NoAdvertiseFoundException() {
		this.message = "";
	}
	public NoAdvertiseFoundException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String toString() {
		return "No advertise found " + this.message;
	}
}
