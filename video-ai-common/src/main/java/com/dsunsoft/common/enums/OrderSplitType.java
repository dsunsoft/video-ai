package com.dsunsoft.common.enums;

/**
 * @ClassName: OrderSplitType
 * @Description:
 * @author ygm
 * @date 2018年4月12日
 */
public enum OrderSplitType {
	无(0), 拆单(1), 合并(2);

	private Integer value;

	OrderSplitType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
