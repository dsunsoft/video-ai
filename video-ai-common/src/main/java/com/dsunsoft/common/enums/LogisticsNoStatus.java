package com.dsunsoft.common.enums;

/**
 * 快递单号状态枚举
 * 
 * @author ygm
 *
 */
public enum LogisticsNoStatus {
	未使用(0), 已使用(1), 作废(-1);

	private Integer value;

	LogisticsNoStatus(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
