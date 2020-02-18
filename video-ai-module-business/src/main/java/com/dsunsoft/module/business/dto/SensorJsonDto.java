package com.dsunsoft.module.business.dto;

import java.io.Serializable;


/**
 * 水质接口返回sensors对象
 * @author zb
 * @date 创建时间：2019年12月17日 上午10:00:27
 */
public class SensorJsonDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2345867012969263653L;

	/**
	 * 序号
	 */
	private Integer index;
	
	/**
	 * 监测参数代码
	 */
	private String code;
	/**
	 * 监测参数名称
	 */
	private String name;
	/**
	 * 监测参数值
	 */
	private String value;
	/**
	 * 监测参数单位
	 */
	private String unit;
	/**
	 * 上报时间 yyyy-MM-dd HH:mm:ss
	 */
	private String time;
	/**
	 * @return the 序号
	 */
	public Integer getIndex() {
		return index;
	}
	
	/**
	 * @param 序号 the index to set
	 */
	public void setIndex(Integer index) {
		this.index = index;
	}
	
	/**
	 * @return the 监测参数代码
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * @param 监测参数代码 the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * @return the 监测参数名称
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param 监测参数名称 the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the 监测参数值
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * @param 监测参数值 the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * @return the 监测参数单位
	 */
	public String getUnit() {
		return unit;
	}
	
	/**
	 * @param 监测参数单位 the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	/**
	 * @return the 上报时间yyyy-MM-ddHH:mm:ss
	 */
	public String getTime() {
		return time;
	}
	
	/**
	 * @param 上报时间yyyy-MM-ddHH:mm:ss the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
	
}
