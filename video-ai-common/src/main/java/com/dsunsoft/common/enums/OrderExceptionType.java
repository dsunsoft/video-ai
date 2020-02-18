package com.dsunsoft.common.enums;

public enum OrderExceptionType {

	未找到商品("商品"), 未匹配快递规则("快递");

	private String value;

	OrderExceptionType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
