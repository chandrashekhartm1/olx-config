package com.olx.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.olx.dto.AuthenticationRequest;
import com.olx.dto.RegistrationRequest;

public interface UserService {

	public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest authenticationRequest);

	public ResponseEntity<Boolean> validateToken(@RequestHeader(value = "Authorization") String authToken);

	public ResponseEntity<String> registerUser(@RequestBody RegistrationRequest authenticationRequest);
	
	public ResponseEntity<RegistrationRequest> getUserInfo(@RequestHeader(value = "Authorization") String authToken);
	
	public ResponseEntity<Boolean> logout(String authToken);
}
