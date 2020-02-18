package com.dsunsoft.module.oauth2.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CorsFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
		
		response.setHeader("Content-Type", "application/json");
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));// 允许域名访问，
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");// 允许的访问方式
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type,Authorization");
		response.setHeader("Access-Control-Expose-Headers", "Content-Length, Content-Type, X-Requested-With");
		response.setHeader("Access-Control-Request-Headers","x-requested-with,content-type,Accept,Authorization");
		response.setHeader("Access-Control-Request-Method", "GET,POST,PUT,DELETE,OPTIONS");

		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			chain.doFilter(req, res);
		}
	}

	@Override
	public void destroy() {
	}
}
