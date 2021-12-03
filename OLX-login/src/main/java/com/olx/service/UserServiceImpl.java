package com.olx.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.olx.dto.AuthenticationRequest;
import com.olx.dto.RegistrationRequest;
import com.olx.entity.UserEntity;
import com.olx.repo.UserRepository;
import com.olx.security.JwtUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseEntity<String> authenticate(AuthenticationRequest authenticationRequest) {
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}

		catch (BadCredentialsException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		String jwtToken = jwtUtil
				.generateToken(userDetailsService.loadUserByUsername(authenticationRequest.getUsername()));
		return new ResponseEntity(jwtToken, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Boolean> validateToken(String authToken) {
		boolean isValid = false;
		try {
			String token = authToken.substring(7);
			isValid = jwtUtil.validateToken(token,
					userDetailsService.loadUserByUsername(jwtUtil.extractUsername(token)));
		} catch (Exception e) {
			return new ResponseEntity(false, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(isValid, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> registerUser(RegistrationRequest registrationRequest) {
		UserEntity UserEntity = this.modelMapper.map(registrationRequest, UserEntity.class);
		UserEntity = this.userRepository.save(UserEntity);
		return new ResponseEntity<String>("Registartion succes", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RegistrationRequest> getUserInfo(String authToken) {
		boolean isValid = false;
		try {
			String token = authToken.substring(7);
			isValid = jwtUtil.validateToken(token,
					userDetailsService.loadUserByUsername(jwtUtil.extractUsername(token)));
			if (isValid) {
				List<UserEntity> userEntity = userRepository.findByUsername(jwtUtil.extractUsername(token));
				RegistrationRequest registrationRequest = this.modelMapper.map(userEntity.get(0), RegistrationRequest.class);
				return new ResponseEntity(registrationRequest, HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity("", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity(false, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Boolean> logout(String authToken) {
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

}
