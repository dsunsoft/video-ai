package com.dsunsoft.common.enums;

/**
 * @ClassName: LogisticsOrderType
 * @Description:
 * @author xr
 * @date 2018年07月23日
 */

public enum LogisticBillNoStatus {
	废止("-1"), 未使用("0"),已使用("1");

	private String value;

	LogisticBillNoStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
