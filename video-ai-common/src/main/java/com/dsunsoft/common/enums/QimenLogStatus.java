package com.dsunsoft.common.enums;

/**
 * @ClassName: QimenLogStatus
 * @Description:订单类型
 * @author ygm
 * @date 2018年11月2日
 */
public enum QimenLogStatus {
	失败(0), 成功(1),待处理(2);
	
	private Integer value;

	QimenLogStatus(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}