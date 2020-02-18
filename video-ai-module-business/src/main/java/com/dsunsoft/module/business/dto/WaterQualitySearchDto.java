package com.dsunsoft.module.business.dto;

import java.util.Date;

import com.dsunsoft.core.entity.BaseSearchDto;

public class WaterQualitySearchDto extends BaseSearchDto {
	private static final long serialVersionUID = -8053693909178470071L;
	private String deviceId;
	private String deviceNo;
	private String deviceName;
	private Integer deviceType;

	private Date startTime;
	
	private Date endTime;


	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}
	

	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	

	/**
	 * @return the deviceNo
	 */
	public String getDeviceNo() {
		return deviceNo;
	}
	

	/**
	 * @param deviceNo the deviceNo to set
	 */
	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}
	

	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}
	

	/**
	 * @param deviceName the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}
	

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}
	

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
	

	

}
