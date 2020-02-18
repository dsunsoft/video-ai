package com.dsunsoft.common.enums;

/**
 * @ClassName: OrderSplitType
 * @Description:
 * @author ygm
 * @date 2018年4月12日
 */
public enum FinChargeType {
	一口价(1), 阶梯价(2),复新率(3);

	private Integer value;

	FinChargeType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
