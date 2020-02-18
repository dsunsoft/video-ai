package com.dsunsoft.common.enums;

/**
 * @ClassName: LogisticsOrderType
 * @Description:
 * @author ygm
 * @date 2018年4月10日
 */

public enum LogisticsOrderType {
	 正常发货(1), 补发漏发(2);

	private Integer value;

	LogisticsOrderType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
