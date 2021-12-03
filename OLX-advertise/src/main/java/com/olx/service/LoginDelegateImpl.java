package com.olx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class LoginDelegateImpl implements LoginDelegate {

	@Autowired
	RestTemplate restTemplate;

	@Override
	@CircuitBreaker(name = "AUTH-TOKEN-VALIDATION", fallbackMethod = "fallBackTokenValidation")
	public boolean validateToken(String token) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", token);
		HttpEntity httpEntity = new HttpEntity(httpHeaders);
		ResponseEntity<Boolean> result = this.restTemplate.exchange("http://API-GATEWAY/olx/user/validate/token",HttpMethod.GET,httpEntity,
				Boolean.class);
 		return result.getBody();

	}

	public boolean fallBackTokenValidation(String token, Exception ex) {
		return false;
	}

}
