package com.olx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.AuthenticationRequest;
import com.olx.dto.RegistrationRequest;
import com.olx.security.JwtUtil;
import com.olx.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/olx/user")
public class UserController {

	@Autowired
	UserService userService;

	// API number: 1 completed
	@ApiOperation("returns Token after succesful login")
	@PostMapping(value = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {

		return userService.authenticate(authenticationRequest);
	}

	// validation of authorization
	@GetMapping(value = "/validate/token")
	@ApiOperation("returns boolen after validating token")
	public ResponseEntity<Boolean> validateToken(@RequestHeader(value = "Authorization") String authToken) {
		return userService.validateToken(authToken);
	}

	// API number: 2 completed
	@GetMapping(value = "/logout")
	@ApiOperation("returns boolen after loging out session")
	public ResponseEntity<Boolean> logout(@RequestHeader(value = "Authorization") String authToken) {
		return userService.logout(authToken);
	}

	// API number: 3 completed
	@ApiOperation("returns success message after registration successful")
	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> registerUser(@RequestBody RegistrationRequest registrationRequest) {
		return userService.registerUser(registrationRequest);
	}

	// API number: 4 completed
	@GetMapping(value = "/user-info")
	@ApiOperation("returns information of logged User")
	public ResponseEntity<RegistrationRequest> getUserInfo(@RequestHeader(value = "Authorization") String authToken) {
		return userService.getUserInfo(authToken);
	}

}
