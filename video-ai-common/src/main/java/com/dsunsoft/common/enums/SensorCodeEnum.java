package com.dsunsoft.common.enums;

/**
 * 水质接口返回的监测参数代码
 * @author zb
 * @date 创建时间：2019年12月17日 上午11:21:35
 */
public enum SensorCodeEnum {
	溶解氧("1","溶解氧","mg/l"),
	浊度("4","浊度","NTU"),
	电导率("3","电导率","mS/cm"),
	叶绿素("13","叶绿素","cells/mL"),
	化学需氧量("6","化学需氧量","mg/m³"),
	酸碱度("2","酸碱度","ph"),
	氨氮("5","氨氮","μg/l"),
	温度("0","温度","℃")
	;
	
	private String code;
	
	private String name;
	
	private String unit;
	

	SensorCodeEnum(String code,String name,String unit) {
		this.code = code;
		this.name = name;
		this.unit = unit;
	}


	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	


	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	


	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}
	


	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
	

	
}