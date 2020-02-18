package com.dsunsoft.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LechangeConfig {
	
	@Value("${video-ai.lechange.appId}")
	private String appId;

	@Value("${video-ai.lechange.appSecret}")
	private String appSecret;
	
	@Value("${video-ai.lechange.host}")
	private String host;
	
	@Value("${video-ai.lechange.port}")
	private String port;

	/**
	 * @return the appId
	 */
	public String getAppId() {
		return appId;
	}
	

	/**
	 * @param appId the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}
	

	/**
	 * @return the appSecret
	 */
	public String getAppSecret() {
		return appSecret;
	}
	

	/**
	 * @param appSecret the appSecret to set
	 */
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}
	

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}
	

	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}
	

	

}
