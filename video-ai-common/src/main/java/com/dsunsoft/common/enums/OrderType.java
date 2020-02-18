package com.dsunsoft.common.enums;

/**
 * @ClassName: OrderType
 * @Description:订单类型
 * @author ygm
 * @date 2018年8月13日
 */
public enum OrderType {
	正常(0), 刷单(-5);
	
	private Integer value;

	OrderType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
