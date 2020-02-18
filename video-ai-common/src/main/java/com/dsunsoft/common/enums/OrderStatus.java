package com.dsunsoft.common.enums;

/**
 * @ClassName: OrderStatus
 * @Description:
 * @author ygm
 * @date 2018年3月22日 当每笔子订单的状态一致时修改主订单的状态
 */

public enum OrderStatus {
	待审核(0), 待配货(1), 已配货(2), 未打印(3), 已打印(4), 已发货(5), 交易关闭(-1), 结转作废(-2);

	private Integer value;

	OrderStatus(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
