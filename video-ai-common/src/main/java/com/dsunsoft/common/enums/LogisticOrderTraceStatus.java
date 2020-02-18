package com.dsunsoft.common.enums;

/**
 * @ClassName: LogisticOrderTraceStatus
 * @Description:
 * @author xr
 */

public enum LogisticOrderTraceStatus {
	无轨迹(0,"无轨迹"), 已揽收(1,"已揽收"), 在途中(2,"在途中"), 签收(3,"签收"), 问题件(4,"问题件");

	private Integer value;
	private String name;

	LogisticOrderTraceStatus(Integer value,String name) {
		this.value = value;
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @Title: getByValue
	 */
	public static LogisticOrderTraceStatus getByValue(Integer value) {
		for (LogisticOrderTraceStatus item : LogisticOrderTraceStatus.values()) {
			if (item.getValue()==value) {
				return item;
			}
		}
		return null;
	}
}
