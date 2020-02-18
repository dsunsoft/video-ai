package com.dsunsoft.module.business.dto;

import java.io.Serializable;
import java.util.List;


/**
 * 水质接口返回对象
 * @author zb
 * @date 创建时间：2019年12月17日 上午10:00:27
 */
public class WaterQualityJsonDto implements Serializable {

	private static final long serialVersionUID = -288818673639556071L;
	/**
	 * 设备名称
	 */
	private String deviceName;
	/**
	 * 设备编号
	 */
	private String deviceNo;
	/**
	 * 地理位置 - 经度
	 */
	private String lng;
	/**
	 * 地理位置 - 纬度
	 */
	private String lat;
	/**
	 * 设备海拔
	 */
	private String elevation;
	/**
	 * 设备IP
	 */
	private String deviceIP;
	/**
	 * 最近一次连接时间 yyyy-MM-dd HH:mm:ss
	 */
	private String connDate;
	
	/**
	 * 指标数据集合
	 */
	private List<SensorJsonDto> sensors;

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
	 * @return the 地理位置-经度
	 */
	public String getLng() {
		return lng;
	}
	

	/**
	 * @param 地理位置-经度 the lng to set
	 */
	public void setLng(String lng) {
		this.lng = lng;
	}
	

	/**
	 * @return the 地理位置-纬度
	 */
	public String getLat() {
		return lat;
	}
	

	/**
	 * @param 地理位置-纬度 the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}
	

	/**
	 * @return the 设备海拔
	 */
	public String getElevation() {
		return elevation;
	}
	

	/**
	 * @param 设备海拔 the elevation to set
	 */
	public void setElevation(String elevation) {
		this.elevation = elevation;
	}
	

	/**
	 * @return the 设备IP
	 */
	public String getDeviceIP() {
		return deviceIP;
	}
	

	/**
	 * @param 设备IP the deviceIP to set
	 */
	public void setDeviceIP(String deviceIP) {
		this.deviceIP = deviceIP;
	}
	

	/**
	 * @return the 最近一次连接时间yyyy-MM-ddHH:mm:ss
	 */
	public String getConnDate() {
		return connDate;
	}
	

	/**
	 * @param 最近一次连接时间yyyy-MM-ddHH:mm:ss the connDate to set
	 */
	public void setConnDate(String connDate) {
		this.connDate = connDate;
	}
	

	/**
	 * @return the 指标数据集合
	 */
	public List<SensorJsonDto> getSensors() {
		return sensors;
	}
	

	/**
	 * @param 指标数据集合 the sensors to set
	 */
	public void setSensors(List<SensorJsonDto> sensors) {
		this.sensors = sensors;
	}
	
	
	
}
