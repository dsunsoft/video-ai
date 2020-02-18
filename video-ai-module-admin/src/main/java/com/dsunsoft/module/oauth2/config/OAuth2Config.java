package com.dsunsoft.module.oauth2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OAuth2Config {

	@Value("${video-ai.oauth2.jwtSigningKey}")
	private String jwtSigningKey;

	@Value("${video-ai.oauth2.enableEncryption}")
	private Boolean enableEncryption;

	@Value("${video-ai.oauth2.clientId}")
	private String clientId;

	@Value("${video-ai.oauth2.clientSecret}")
	private String clientSecret;

	@Value("${video-ai.oauth2.expiresIn}")
	private Integer expiresIn;

	public String getJwtSigningKey() {
		return jwtSigningKey;
	}

	public void setJwtSigningKey(String jwtSigningKey) {
		this.jwtSigningKey = jwtSigningKey;
	}

	public Boolean getEnableEncryption() {
		return enableEncryption;
	}

	public void setEnableEncryption(Boolean enableEncryption) {
		this.enableEncryption = enableEncryption;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

}
