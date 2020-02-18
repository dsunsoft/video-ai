package com.dsunsoft.common.enums;

/**
 * @ClassName: OrderPickStatus
 * @Description:
 * @author ygm
 * @date 2018年4月13日
 */
public enum LogisticOrderNoStatus {
	正在使用("1"), 作废("-1");
	
	private String value;

	LogisticOrderNoStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
