package com.dsunsoft.module.business.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.dsunsoft.core.entity.BaseEntity;


/**
 * 水质信息 
 * 指标信息保留两位小数
 * @author zb
 * @date 创建时间：2019年12月17日 上午9:29:02
 */
public class WaterQuality extends BaseEntity {

	private static final long serialVersionUID = 2947249328998272397L;
	
	private String id;
	/**
	 * 设备信息
	 */
	private Device device;
	
	/**
	 * 设备ID
	 */
	private String deviceId;
	
	/**
	 * 设备编号
	 */
	private String deviceNo;
	/**
	 * 设备名称
	 */
	private String deviceName;
	
	/**
	 * 时间
	 */
	private Date time;
	/**
	 * 溶解氧"code":"1", "unit":"mg/l"
	 */
	private BigDecimal dissolvedOxygen;
	/**
	 * 浊度  "code": "4", "unit":"NTU"
	 */
	private BigDecimal turbidity;
	/**
	 * 电导率  "code": "3", "unit":"mS/cm"
	 */
	private BigDecimal conductivity;
	/**
	 * 叶绿素  "code": "13", "unit":"cells/mL"
	 */
	private BigDecimal chlorophyll;
	/**
	 * 化学需氧量 "code": "6", "unit":"mg/m³"
	 */
	private BigDecimal chemicalOxygen;
	/**
	 * 酸碱度 "code": "2", "unit":"ph"
	 */
	private BigDecimal ph;
	/**
	 * 氨氮 "code": "7", "unit":"μg/l"
	 */
	private BigDecimal ammoniaNitrogen;
	/**
	 * 温度 "code": "0", "unit":"℃"
	 */
	private BigDecimal temperature;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the 设备ID
	 */
	public String getDeviceId() {
		return deviceId;
	}
	
	/**
	 * @param 设备ID the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	/**
	 * @return the 设备编号
	 */
	public String getDeviceNo() {
		return deviceNo;
	}
	
	/**
	 * @param 设备编号 the deviceNo to set
	 */
	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}
	
	/**
	 * @return the 设备名称
	 */
	public String getDeviceName() {
		return deviceName;
	}
	
	/**
	 * @param 设备名称 the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	
	/**
	 * @return the 时间
	 */
	public Date getTime() {
		return time;
	}
	
	/**
	 * @param 时间 the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	
	/**
	 * @return the 溶解氧"code":"1""unit":"mgl"
	 */
	public BigDecimal getDissolvedOxygen() {
		return dissolvedOxygen;
	}
	
	/**
	 * @param 溶解氧"code":"1""unit":"mgl" the dissolvedOxygen to set
	 */
	public void setDissolvedOxygen(BigDecimal dissolvedOxygen) {
		this.dissolvedOxygen = dissolvedOxygen;
	}
	
	/**
	 * @return the 浊度"code":"4""unit":"NTU"
	 */
	public BigDecimal getTurbidity() {
		return turbidity;
	}
	
	/**
	 * @param 浊度"code":"4""unit":"NTU" the turbidity to set
	 */
	public void setTurbidity(BigDecimal turbidity) {
		this.turbidity = turbidity;
	}
	
	/**
	 * @return the 电导率"code":"3""unit":"mScm"
	 */
	public BigDecimal getConductivity() {
		return conductivity;
	}
	
	/**
	 * @param 电导率"code":"3""unit":"mScm" the conductivity to set
	 */
	public void setConductivity(BigDecimal conductivity) {
		this.conductivity = conductivity;
	}
	
	/**
	 * @return the 叶绿素"code":"13""unit":"cellsmL"
	 */
	public BigDecimal getChlorophyll() {
		return chlorophyll;
	}
	
	/**
	 * @param 叶绿素"code":"13""unit":"cellsmL" the chlorophyll to set
	 */
	public void setChlorophyll(BigDecimal chlorophyll) {
		this.chlorophyll = chlorophyll;
	}
	
	/**
	 * @return the 化学需氧量"code":"6""unit":"mgm³"
	 */
	public BigDecimal getChemicalOxygen() {
		return chemicalOxygen;
	}
	
	/**
	 * @param 化学需氧量"code":"6""unit":"mgm³" the chemicalOxygen to set
	 */
	public void setChemicalOxygen(BigDecimal chemicalOxygen) {
		this.chemicalOxygen = chemicalOxygen;
	}
	
	/**
	 * @return the 酸碱度"code":"2""unit":"ph"
	 */
	public BigDecimal getPh() {
		return ph;
	}
	
	/**
	 * @param 酸碱度"code":"2""unit":"ph" the 酸碱度"code":"2""unit":"ph" to set
	 */
	public void setPh(BigDecimal ph) {
		this.ph = ph;
	}
	
	/**
	 * @return the 氨氮"code":"7""unit":"μgl"
	 */
	public BigDecimal getAmmoniaNitrogen() {
		return ammoniaNitrogen;
	}
	
	/**
	 * @param 氨氮"code":"7""unit":"μgl" the ammoniaNitrogen to set
	 */
	public void setAmmoniaNitrogen(BigDecimal ammoniaNitrogen) {
		this.ammoniaNitrogen = ammoniaNitrogen;
	}
	
	/**
	 * @return the 温度"code":"0""unit":"℃"
	 */
	public BigDecimal getTemperature() {
		return temperature;
	}
	
	/**
	 * @param 温度"code":"0""unit":"℃" the temperature to set
	 */
	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return the device
	 */
	public Device getDevice() {
		return device;
	}

	/**
	 * @param device the device to set
	 */
	public void setDevice(Device device) {
		this.device = device;
	}
	
	
	
	
	
	
}
