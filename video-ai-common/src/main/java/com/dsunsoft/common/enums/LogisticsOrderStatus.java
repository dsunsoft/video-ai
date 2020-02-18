package com.dsunsoft.common.enums;

/**
 * @ClassName: LogisticsOrderStatus
 * @Description:
 * @author ygm
 * @date 2018年4月12日
 */
public enum LogisticsOrderStatus {
	未发货(1), 已发货(2), 已签收(3), 交易关闭(-1);

	private Integer value;

	LogisticsOrderStatus(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
