package com.dsunsoft.common.enums;

/**
 * 系统日志类别
 * 
 * @author ygm
 *
 */
public enum SysLogType {
	/**
	 * 接入日志
	 */
	TYPE_ACCESS("1"),
	/**
	 * 错误日志
	 */
	TYPE_EXCEPTION("2");
	private String value;

	private SysLogType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
