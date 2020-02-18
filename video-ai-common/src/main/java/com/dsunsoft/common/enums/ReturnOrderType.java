package com.dsunsoft.common.enums;

/**
 * @ClassName: LogisticsOrderType
 * @Description:
 * @author xr
 * @date 2018年07月23日
 */

public enum ReturnOrderType {
	退货入库("THRK"), 换货入库("HHRK");

	private String value;

	ReturnOrderType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
