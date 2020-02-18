package com.dsunsoft.common.enums;

/**
 * @ClassName: OrderPrintStatus
 * @Description:
 * @author ygm
 * @date 2018年3月28日
 */

public enum OrderPrintStatus {
	无需审核(0), 待审核(1), 已审核(2);

	private Integer value;

	OrderPrintStatus(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
