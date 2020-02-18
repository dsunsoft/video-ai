package com.dsunsoft.common.enums;

/**
 * @ClassName: OrderReturnStatus
 * @Description:
 * @author ygm
 * @date 2018年3月22日
 */

public enum OrderReturnStatus {
	正常(0), 成功(2), 失败(-1);

	private Integer value;

	OrderReturnStatus(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
