package com.dsunsoft.common.enums;

/**
 * 仓库类型
 * 
 * @author ygm
 *
 */
public enum WareHouseType {
	正品仓(1), 残次仓(-1);

	private Integer value;

	WareHouseType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
