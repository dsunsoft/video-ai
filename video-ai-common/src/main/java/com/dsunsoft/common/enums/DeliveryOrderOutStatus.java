package com.dsunsoft.common.enums;

/**
 * @ClassName: LogisticsOrderType
 * @Description:
 * @author xr
 * @date 2018年07月23日
 */

public enum DeliveryOrderOutStatus {
	//NEW-未开始处理;ACCEPT-仓库接单;PARTDELIVERED-部分发货完成;DELIVERED-发货完成;EXCEPTION-异 常;CANCELED-取消;CLOSED-关闭;REJECT-拒单;CANCELEDFAIL-取消失败
	未开始处理("NEW"), 仓库接单("ACCEPT"),部分发货完成("PARTDELIVERED"),发货完成("DELIVERED"),
	异常("EXCEPTION"),取消("CANCELED"),关闭("CLOSED"),拒单("REJECT"),取消失败("CANCELEDFAIL");

	private String value;

	DeliveryOrderOutStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
