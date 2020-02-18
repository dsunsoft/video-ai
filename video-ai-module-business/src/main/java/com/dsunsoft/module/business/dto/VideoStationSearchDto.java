package com.dsunsoft.module.business.dto;

import com.dsunsoft.core.entity.BaseSearchDto;

public class VideoStationSearchDto extends BaseSearchDto {
	private static final long serialVersionUID = -8053693909178470071L;
	/**
	 * 设备序列号
	 */
	private String deviceId;
	/**
	 * 通道号
	 */
    private String channelId;
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
	 * @return the channelId
	 */
	public String getChannelId() {
		return channelId;
	}

	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
}
