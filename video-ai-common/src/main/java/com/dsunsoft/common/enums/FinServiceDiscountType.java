package com.dsunsoft.common.enums;

/**
 * @ClassName: TradePlatform
 * @Description:
 * @author ygm
 * @date 2018年3月22日
 */

public enum FinServiceDiscountType {
	体积法(1), 托盘法(2),格数法(3);

	private Integer value;

	FinServiceDiscountType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
