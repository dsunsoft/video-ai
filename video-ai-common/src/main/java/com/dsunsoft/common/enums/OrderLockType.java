package com.dsunsoft.common.enums;

/**
 * @ClassName: OrderSplitType
 * @Description:
 * @author ygm
 * @date 2018年4月12日
 */
public enum OrderLockType {
	否(0), 是(1);

	private Integer value;

	OrderLockType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
