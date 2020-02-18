package com.dsunsoft.common.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class SysLogDto implements Serializable {
	private static final long serialVersionUID = 2289956951710325467L;
	private String title; // 日志标题
	private String operBy;// 操作用户
	private String operCompanyName;// 所在公司
	private String operOfficeName;// 所在部门
	private String requestUri; // 操作的URI
	private String method; // 操作的方式
	private String remoteAddr; // 操作用户的IP地址
	private String exception; // 异常信息
}
