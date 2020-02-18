package com.dsunsoft.common.enums;

/**
 * 
 * 1：国家；2：省份、直辖市；3：地市；4：区县
 * 
 * @author ygm
 *
 */
public enum AreaType {
	国家("1"), 省份("2"), 地市("3"), 区县("4");
	
	private String value;

	AreaType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
