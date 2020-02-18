package com.dsunsoft.common.enums;

/**
 * @ClassName: OrderReturnStatus
 * @Description:
 * @author ygm
 * @date 2018年3月22日
 */

public enum InWarehouseType {
	正常入库(1), 刷单入库(2), 残次换包装维修入库(3), 残次入库(4);

	private Integer value;

	InWarehouseType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
