package com.audit.springjwt.payload;

public class JwtResponse {
	private String accessToken;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private int jwtExpirationMs;

	public JwtResponse(String accessToken, Long id, String username, String email,int jwtExpirationMs) {
		this.accessToken = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.jwtExpirationMs = jwtExpirationMs;
	}
	public int getJwtExpirationMs() {
		return jwtExpirationMs;
	}
	public void setJwtExpirationMs(int jwtExpirationMs) {
		this.jwtExpirationMs = jwtExpirationMs;
	}
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}