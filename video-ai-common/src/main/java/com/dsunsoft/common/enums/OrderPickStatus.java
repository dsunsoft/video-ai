package com.dsunsoft.common.enums;

/**
 * @ClassName: OrderPickStatus
 * @Description:
 * @author ygm
 * @date 2018年4月13日
 */
public enum OrderPickStatus {
	未打印(1), 已打印(2), 作废(-1);
	
	private Integer value;

	OrderPickStatus(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
