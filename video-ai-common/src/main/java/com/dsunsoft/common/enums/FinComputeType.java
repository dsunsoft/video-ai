package com.dsunsoft.common.enums;

/**
 * 计算类型
 * 
 * @author ygm
 *
 */
public enum FinComputeType {

	按台计算(1), 按体积计算(2);

	private Integer value;

	FinComputeType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
