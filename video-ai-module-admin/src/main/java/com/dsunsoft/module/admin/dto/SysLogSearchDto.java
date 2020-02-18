package com.dsunsoft.module.admin.dto;

import java.util.Date;

import com.dsunsoft.core.entity.BaseSearchDto;
import com.fasterxml.jackson.annotation.JsonFormat;

public class SysLogSearchDto extends BaseSearchDto {
	private static final long serialVersionUID = -433901435508366271L;
	private String type; // 日志类型（1：接入日志；2：错误日志）
	private String title; // 日志标题
	private String requestUri; // 操作的URI
	private String operBy;//操作用户
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date beginDate; // 开始日期
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate; // 结束日期
	
	// 日志类型（1：接入日志；2：错误日志）
	public static final String TYPE_ACCESS = "1";
	public static final String TYPE_EXCEPTION = "2";

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getOperBy() {
		return operBy;
	}

	public void setOperBy(String operBy) {
		this.operBy = operBy;
	}
}
