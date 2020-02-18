package com.dsunsoft.module.business.dto;

import com.dsunsoft.core.entity.BaseSearchDto;

public class DeviceSearchDto extends BaseSearchDto {
	private static final long serialVersionUID = -8053693909178470071L;
	private String deviceNo;
	private String deviceName;
	private Integer deviceType;

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
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
	

	
	

}
