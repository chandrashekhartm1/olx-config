package com.olx.masterdata.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = {InvalidAdvertiseIdException.class})
	public ResponseEntity<Object> handleInvalidAdvertiseIdException(RuntimeException exception,
			WebRequest webRequest){
		return handleExceptionInternal(exception, exception.toString(), new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
	}

	@ExceptionHandler(value = {InvalidAuthTokenException.class})
	public ResponseEntity<Object> handleInvalidAuthTokenException(RuntimeException exception,
			WebRequest webRequest){
		return handleExceptionInternal(exception, exception.toString(), new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
	}

	@ExceptionHandler(value = {InvalidCategoryIdException.class})
	public ResponseEntity<Object> handleInvalidCategoryIdException(RuntimeException exception,
			WebRequest webRequest){
		return handleExceptionInternal(exception, exception.toString(), new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
	}

	@ExceptionHandler(value = {InvalidDateConditionException.class})
	public ResponseEntity<Object> handleInvalidDateConditionException(RuntimeException exception,
			WebRequest webRequest){
		return handleExceptionInternal(exception, exception.toString(), new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
	}

	@ExceptionHandler(value = {InvalidOnDateException.class})
	public ResponseEntity<Object> handleInvalidOnDateException(RuntimeException exception,
			WebRequest webRequest){
		return handleExceptionInternal(exception, exception.toString(), new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
	}

	@ExceptionHandler(value = {InvalidRecordNoException.class})
	public ResponseEntity<Object> handleInvalidRecordNoException(RuntimeException exception,
			WebRequest webRequest){
		return handleExceptionInternal(exception, exception.toString(), new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
	}

	@ExceptionHandler(value = {InvalidStartIndexException.class})
	public ResponseEntity<Object> handleInvalidStartIndexException(RuntimeException exception,
			WebRequest webRequest){
		return handleExceptionInternal(exception, exception.toString(), new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
	}

	@ExceptionHandler(value = {InvalidStatusIdException.class})
	public ResponseEntity<Object> handleInvalidStatusIdException(RuntimeException exception,
			WebRequest webRequest){
		return handleExceptionInternal(exception, exception.toString(), new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
	}

}
