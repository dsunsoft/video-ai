package com.dsunsoft.module.business.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.dsunsoft.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 设备信息
 * @author zb
 * @date 创建时间：2019年12月17日 上午9:29:02
 */
public class Device extends BaseEntity {

	private static final long serialVersionUID = 2947249328998272397L;
	
	private String id;
	/**
	 * 设备名称
	 */
	@NotNull(message = "设备名称不能为空")
	private String deviceName;
	/**
	 * 设备编号
	 */
	@NotNull(message = "设备编码不能为空")
	private String deviceNo;

	/**
	 * 设备编号
	 */
	@NotNull(message = "设备类型不能为空")
	private Integer deviceType;
	/**
	 * 地理位置 - 经度
	 */
	private BigDecimal lng;
	/**
	 * 地理位置 - 纬度
	 */
	private BigDecimal lat;
	/**
	 * 设备海拔
	 */
	private BigDecimal elevation;
	/**
	 * 设备IP
	 */
	private String deviceIP;
	/**
	 * 最近一次连接时间 yyyy-MM-dd HH:mm:ss
	 */
	private Date connDate;
	
	
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

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @return the 地理位置-经度
	 */
	public BigDecimal getLng() {
		return lng;
	}
	
	/**
	 * @param 地理位置-经度 the lng to set
	 */
	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}
	
	/**
	 * @return the 地理位置-纬度
	 */
	public BigDecimal getLat() {
		return lat;
	}
	
	/**
	 * @param 地理位置-纬度 the lat to set
	 */
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	
	/**
	 * @return the 设备海拔
	 */
	public BigDecimal getElevation() {
		return elevation;
	}
	
	/**
	 * @param 设备海拔 the elevation to set
	 */
	public void setElevation(BigDecimal elevation) {
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
	public Date getConnDate() {
		return connDate;
	}
	
	/**
	 * @param 最近一次连接时间yyyy-MM-ddHH:mm:ss the connDate to set
	 */
	public void setConnDate(Date connDate) {
		this.connDate = connDate;
	}
	
	
	
	
	
	
	

}
