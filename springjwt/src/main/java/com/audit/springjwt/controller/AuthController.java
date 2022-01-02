package com.audit.springjwt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audit.springjwt.payload.LoginRequest;
import com.audit.springjwt.payload.JwtResponse;
import com.audit.springjwt.security.JwtUtils;
import com.audit.springjwt.security.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	/*
	 * Attempts to authenticate the passed Authentication object, returning a fully
	 * populated Authentication object (including granted authorities) if successful
	 */
	@Autowired
	AuthenticationManager authenticationManager;

	/*
	 * the JwtUtil class is in charge of parsing the token into User object and
	 * generating the token from the User object. It is straightforward since it
	 * uses the jjwt library to do all the JWT work.
	 */
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Value("${audit.app.jwtExpirationMs}")
	private int jwtExpirationMs;
	

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid  @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		
		return ResponseEntity.ok(new JwtResponse(jwt, 
				 userDetails.getId(), 
				 userDetails.getUsername(), 
				 userDetails.getEmail(),jwtExpirationMs));
	}

	
}
