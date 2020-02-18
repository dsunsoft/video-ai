package com.dsunsoft.common.entity;

/**
 * 自定义错误码<br/>
 * 统一格式为 A-BB-CC<br/>
 * A：代表错误级别，1表示系统级错误，2表示服务级错误。<br/>
 * BB：代表错误项目或者模块号，从00开始。<br/>
 * CC：具体错误编号，自增从00开始<br/>
 * 
 * @author ygm
 *
 */
public enum ResponseCode {
	SUCCESS(200, "成功"), 
	FAILURE(0, "失败"), 
	/*################# 系统错误 #####################*/
	SYSTEM_ERROR(10000, "系统错误"),
	SERVICE_UNAVAILABLE(10001, "服务暂停"),
	ILLEGAL_REQUEST(10002,"非法请求"),
	PERMISSION_NO_lOGIN(10003,"未登录"),
	PERMISSION_NO_ACCESS(10004, "无访问权限"),
	RETURN_IS_NULL(10009, "结果不存在"),
	PARAM_IS_INVALID(10010, "参数无效"),
	PARAM_IS_BLANK(10011, "参数为空"), 
	PARAM_TYPE_ERROR(10012,"参数类型错误"), 
	PARAM_NOT_COMPLETE(10013, "参数缺失"),
	/*################# 服务级错误 #####################*/
	USER_EXISTS(20000,"用户已存在"),
	USER_NOT_EXISTS(20001,"用户不存在")
	;

	private int code;
	private String message;

	private ResponseCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
