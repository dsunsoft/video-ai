package com.dsunsoft.module.oauth2.exception;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = CustomizeOauthExceptionSerializer.class)
public class CustomizeOauthException extends OAuth2Exception {
	private static final long serialVersionUID = -2506159678949541171L;

	public CustomizeOauthException(String msg) {
        super(msg);
    }
}
