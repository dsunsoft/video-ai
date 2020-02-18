package com.dsunsoft.module.oauth2.exception;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 自定义权限不足处理
 * 
 * @author ygm
 *
 */
public class CustomizeAccessDeniedHandler implements AccessDeniedHandler {

	private static final Logger logger = LoggerFactory.getLogger(CustomizeAccessDeniedHandler.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		logger.error("权限不足异常," + accessDeniedException.getMessage());

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", HttpServletResponse.SC_UNAUTHORIZED);// 401
		map.put("message", accessDeniedException.getMessage());
		map.put("path", request.getServletPath());
		map.put("timestamp", String.valueOf(new Date().getTime()));

		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("application/json;charset=UTF-8");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getWriter().write(mapper.writeValueAsString(map));
	}
}