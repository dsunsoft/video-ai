package com.dsunsoft.common.enums;

/**
 * @ClassName: OrderReturnStatus
 * @Description:
 * @author ygm
 * @date 2018年3月22日
 */

public enum OrderReturnQcType {
	无(1), 换包装(2), 换包装并维修(3), 损坏(4);

	private Integer value;

	OrderReturnQcType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
