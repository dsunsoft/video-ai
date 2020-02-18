package com.dsunsoft.common.enums;

/**
 * @ClassName: LogisticsOrderType
 * @Description:
 * @author xr
 * @date 2018年07月23日
 */

public enum DeliveryOrderType {
	一般交易出库单("JYCK"), 换货出库单("HHCK"),补发出库单("BFCK"),其他出库单("QTCK");

	private String value;

	DeliveryOrderType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
