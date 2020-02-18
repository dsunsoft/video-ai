package com.dsunsoft.module.oauth2.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class SimpleCORSFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
//		response.setHeader("Content-Type", "application/json");
//		response.setHeader("Access-Control-Allow-Origin", "*");// 允许所以域名访问，
//		response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");// 允许的访问方式
//		response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type,Authorization");
//		response.setHeader("Access-Control-Request-Headers",
//				"x-requested-with,content-type,Accept,Authorization");
//		response.setHeader("Access-Control-Request-Method", "GET,POST,PUT,DELETE,OPTIONS");
		
		response.setHeader("Content-Type", "application/json");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));// 允许域名访问，
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");// 允许的访问方式
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type,Authorization");
        response.setHeader("Access-Control-Expose-Headers", "Content-Length, Content-Type, X-Requested-With");
        response.setHeader("Access-Control-Request-Headers","x-requested-with,content-type,Accept,Authorization");
        response.setHeader("Access-Control-Request-Method", "GET,POST,PUT,DELETE,OPTIONS");
		filterChain.doFilter(request, response);
	}
}
