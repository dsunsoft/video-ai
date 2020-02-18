package com.dsunsoft.common.enums;

/**
 * @ClassName: OrderReturnStatus
 * @Description:
 * @author ygm
 * @date 2018年3月22日
 */

public enum OrderReturnBizType {
	仓库原因退货(1), 快递原因退货(2), 买家原因退货(3),其他仓库退货(4);

	private Integer value;

	OrderReturnBizType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
