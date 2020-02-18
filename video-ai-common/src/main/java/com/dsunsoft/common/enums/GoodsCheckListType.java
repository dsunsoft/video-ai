package com.dsunsoft.common.enums;

/**
 * 0：待审核；1：已审核；-1：作废；
 */
public enum GoodsCheckListType {
	待审核(0), 已审核(1), 作废(-1);
	private Integer value;

	GoodsCheckListType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
