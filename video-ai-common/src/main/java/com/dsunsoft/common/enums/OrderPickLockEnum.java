package com.dsunsoft.common.enums;

/**
 * 配货单锁定枚举
 * 
 * @author ygm
 *
 */
public enum OrderPickLockEnum {
	/**
	 * 已锁定
	 */
	LOCKED(1),
	/**
	 * 未锁定
	 */
	UNLOCKED(0);
	private Integer value;

	OrderPickLockEnum(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
