package com.dsunsoft.module.oauth2.config;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 认证授权异常处理
 * 
 * @author ygm
 *
 */
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {

	private static final Logger logger = LoggerFactory.getLogger(AuthExceptionEntryPoint.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws ServletException, JsonProcessingException, IOException {
		logger.error("未登录授权异常," + authException.getMessage());

		Map<String, Object> map = new HashMap<>();
		map.put("code", HttpServletResponse.SC_UNAUTHORIZED);// 401
		map.put("message", authException.getMessage());
		map.put("path", request.getServletPath());
		map.put("timestamp", String.valueOf(new Date().getTime()));

		response.setContentType("application/json;charset=UTF-8");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		ObjectMapper mapper = new ObjectMapper();
		response.getWriter().write(mapper.writeValueAsString(map));
	}
}