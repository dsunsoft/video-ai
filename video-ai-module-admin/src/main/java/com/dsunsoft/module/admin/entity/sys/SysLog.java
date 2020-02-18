package com.dsunsoft.module.admin.entity.sys;

import com.dsunsoft.core.entity.BaseEntity;

public class SysLog extends BaseEntity {
	private static final long serialVersionUID = -433901435508366271L;
	private String id;
	private String title; // 日志标题
	private String operBy;// 操作用户
	private String operCompanyName;// 所在公司
	private String operOfficeName;// 所在部门
	private String requestUri; // 操作的URI
	private String method; // 操作的方式
	private String remoteAddr; // 操作用户的IP地址
	private String exception; // 异常信息

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getOperBy() {
		return operBy;
	}

	public void setOperBy(String operBy) {
		this.operBy = operBy;
	}

	public String getOperCompanyName() {
		return operCompanyName;
	}

	public void setOperCompanyName(String operCompanyName) {
		this.operCompanyName = operCompanyName;
	}

	public String getOperOfficeName() {
		return operOfficeName;
	}

	public void setOperOfficeName(String operOfficeName) {
		this.operOfficeName = operOfficeName;
	}
}
