package com.dsunsoft.core.util;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;

import com.dsunsoft.common.constant.SecurityConstants;
import com.dsunsoft.common.constant.WebConstants;
import com.dsunsoft.common.util.SpringContextHolder;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * 用户相关工具类
 */
public class JwtUtil {
	private static Logger logger = LoggerFactory.getLogger(JwtUtil.class);

	/**
	 * 根据用户请求中的token 获取用户id
	 *
	 * @param request
	 *            Request
	 * @return "" userid
	 */
	public static String getUserId(HttpServletRequest request) {
		String jwtkey = SpringContextHolder.getJwtSigningKey();
		Claims claims = buildClaims(getToken(request), jwtkey);
		if (null == claims)
			return "";
		return claims.get(SecurityConstants.JWT_USER_NAME).toString();
	}

	/**
	 * 根据请求heard中的token获取用户角色
	 *
	 * @param httpServletRequest
	 *            request
	 * @return 角色名
	 */
	public static List<String> getRole(HttpServletRequest httpServletRequest) {
		String jwtkey = SpringContextHolder.getJwtSigningKey();
		return getRole(getToken(httpServletRequest), jwtkey);
	}

	/**
	 * 获取请求中token
	 */
	public static String getToken(HttpServletRequest httpServletRequest) {
		String authorization = httpServletRequest.getHeader(SecurityConstants.REQ_HEADER);
		return buildToken(authorization);
	}

	/**
	 * jwt 解密
	 */
	private static Claims buildClaims(String token, String jwtkey) {
		if (StringUtils.isBlank(token) || StringUtils.isBlank(jwtkey))
			return null;

		String key = "";
		try {
			key = Base64.getEncoder().encodeToString(jwtkey.getBytes());
			Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
			return claims;
		} catch (Exception ex) {
			logger.error("用户TOKEN解析异常,token:{},key:{}", token, key);
		}
		return null;
	}

	/**
	 * 根据请求heard中的token获取用户角色
	 *
	 * @param httpServletRequest
	 *            request
	 * @return 角色名
	 */
	@SuppressWarnings("unchecked")
	private static List<String> getRole(String token, String jwtkey) {
		Claims claims = buildClaims(buildToken(token), jwtkey);
		if (null == claims)
			return new ArrayList<String>();

		List<String> roleCodes = (List<String>) claims.get(SecurityConstants.JWT_USER_AUTHORITIES);
		return roleCodes;
	}

	/**
	 * buildToken
	 * 
	 * @param token
	 * @return
	 */
	private static String buildToken(String token) {
		if (StringUtils.isBlank(token))
			return null;
		if (!token.contains(SecurityConstants.TOKEN_SPLIT))
			return token;
		return StringUtils.substringAfter(token, SecurityConstants.TOKEN_SPLIT);
	}
}
