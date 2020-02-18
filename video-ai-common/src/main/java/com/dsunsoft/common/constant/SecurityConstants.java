package com.dsunsoft.common.constant;

/**
 * SecurityConstants
 * 
 * @author ygm
 *
 */
public class SecurityConstants {

	/** 授权 */
	public static final String AUTHORIZATION = "Authorization";

	/** clinet授权模式 */
	public static final String BASIC = "Basic ";

	/** 授权码模式 */
	public static final String AUTHORIZATION_CODE = "authorization_code";

	/** 密码模式 */
	public static final String PASSWORD = "password";

	/** * 刷新token */
	public static final String REFRESH_TOKEN = "refresh_token";

	/** oauth token */
	public static final String OAUTH_TOKEN_URL = "/oauth/token";

	/** 手机登录URL */
	public static final String MOBILE_TOKEN_URL = "/mobile/token";

	/** JWT 用户对象key */
	public static final String JWT_USER_NAME = "user_name";

	/** JWT 用户权限 */
	public static final String JWT_USER_AUTHORITIES = "authorities";

	/** Token-AuthUser */
	public static final String TOKEN_USER_DETAIL = "token-user-detail";

	/** 用户信息头 */
	public static final String USER_HEADER = "request-user-header";

	/** 角色信息头 */
	public static final String ROLE_HEADER = "request-role-header";

	/** token请求头名称 */
	public static final String REQ_HEADER = "Authorization";

	/** token分割符 */
	public static final String TOKEN_SPLIT = "Bearer ";

	/** JWT 定义的user */
	public static final String KEY_USER = "user";

	/** JWT 手机号码登录 */
	public static final String SPRING_SECURITY_FORM_MOBILE_KEY = "mobile";
}
