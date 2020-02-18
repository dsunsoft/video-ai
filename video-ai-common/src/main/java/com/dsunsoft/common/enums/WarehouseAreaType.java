package com.dsunsoft.common.enums;

/**
 * 仓库库区类型枚举
 * 
 * @author ygm
 *
 */
public enum WarehouseAreaType {

	正品区(1), 残次区(2),操作区(5);

	private Integer value;

	WarehouseAreaType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
