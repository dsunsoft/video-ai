package com.dsunsoft.common.enums;

/**
 * 收支科目类型
 * 
 * @author ygm
 *
 */
public enum FinSubjectType {

	收入(1), 支出(2);

	private Integer value;

	FinSubjectType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
