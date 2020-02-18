package com.dsunsoft.common.enums;

/**
 * @ClassName: OrderReturnStatus
 * @Description:
 * @author ygm
 * @date 2018年3月22日
 */

public enum WhOutHouseStatus {

	正常发货出库(1), 补发漏发出库(2), 自提出库(3);

	private Integer value;

	WhOutHouseStatus(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
