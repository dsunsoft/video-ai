package com.dsunsoft.common.enums;

/**
 * @ClassName: OrderReturnType
 * @Description:
 * @author ygm
 * @date 2018年4月16日
 */

public enum OrderReturnType {
	正常(0), 截单(1), 退货(2);

	private Integer value;

	OrderReturnType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
