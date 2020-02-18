package com.dsunsoft.common.enums;

/**
 * @ClassName: OrderLogType
 * @Description:
 * @author ygm
 * @date 2018年4月20日
 */

public enum OrderLogType {
	新增(1), 修改(2), 拆分合并(3), 配货(4), 配货打印(5), 预约快递单号(6), 快递单打印(7), 发货(8), 补发漏发(9), 截单(10), 退货(11), 配货单作废(12), 批量修改快递公司(99);
	private Integer value;

	OrderLogType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
