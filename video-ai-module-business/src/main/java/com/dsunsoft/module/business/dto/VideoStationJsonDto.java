package com.dsunsoft.module.business.dto;

import java.io.Serializable;
import java.util.List;


/**
 * 乐橙云视频接口返回对象
 * @author zb
 * @date 创建时间：2019年12月17日 上午10:00:27
 */
public class VideoStationJsonDto implements Serializable {

	private static final long serialVersionUID = -288818673639556071L;
	
	/**
	 * 设备序列号
	 */
	private String deviceId;
	/**
	 * 通道号
	 */
    private String channelId;
    /**
    * 直播状态（1：开启；2：暂停；3：流量不足）
    */
    private Integer liveStatus;
    /**
     * 直播授权token
     */
    private String liveToken;
    /**
     * 直播源类型（1：设备；2：流地址）
     */
    private Integer liveType;
    /**
     * 直播类型（"cdn":通用直播；"proxy":经济型直播）
     */
    private String liveMode;
    /**
     * 视频封面更新频率（单位：s）
     */
    private Integer coverUpdate;
    /**
     * 直播流信息
     */
	private List<StreamJson> streams;
	/**
	 * 直播计划时间
	 */
	private List<JobJson> job;
	/**
	 * @return the 设备序列号
	 */
	public String getDeviceId() {
		return deviceId;
	}
	
	/**
	 * @param 设备序列号 the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	/**
	 * @return the 通道号
	 */
	public String getChannelId() {
		return channelId;
	}
	
	/**
	 * @param 通道号 the channelId to set
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	
	/**
	 * @return the 直播状态（1：开启；2：暂停；3：流量不足）
	 */
	public Integer getLiveStatus() {
		return liveStatus;
	}
	
	/**
	 * @param 直播状态（1：开启；2：暂停；3：流量不足） the liveStatus to set
	 */
	public void setLiveStatus(Integer liveStatus) {
		this.liveStatus = liveStatus;
	}
	
	/**
	 * @return the 直播授权token
	 */
	public String getLiveToken() {
		return liveToken;
	}
	
	/**
	 * @param 直播授权token the liveToken to set
	 */
	public void setLiveToken(String liveToken) {
		this.liveToken = liveToken;
	}
	
	/**
	 * @return the 直播源类型（1：设备；2：流地址）
	 */
	public Integer getLiveType() {
		return liveType;
	}
	
	/**
	 * @param 直播源类型（1：设备；2：流地址） the liveType to set
	 */
	public void setLiveType(Integer liveType) {
		this.liveType = liveType;
	}
	
	/**
	 * @return the 直播类型（"cdn":通用直播；"proxy":经济型直播）
	 */
	public String getLiveMode() {
		return liveMode;
	}
	
	/**
	 * @param 直播类型（"cdn":通用直播；"proxy":经济型直播） the liveMode to set
	 */
	public void setLiveMode(String liveMode) {
		this.liveMode = liveMode;
	}
	
	/**
	 * @return the 视频封面更新频率（单位：s）
	 */
	public Integer getCoverUpdate() {
		return coverUpdate;
	}
	
	/**
	 * @param 视频封面更新频率（单位：s） the coverUpdate to set
	 */
	public void setCoverUpdate(Integer coverUpdate) {
		this.coverUpdate = coverUpdate;
	}
	
	/**
	 * @return the 直播流信息
	 */
	public List<StreamJson> getStreams() {
		return streams;
	}
	
	/**
	 * @param 直播流信息 the streams to set
	 */
	public void setStreams(List<StreamJson> streams) {
		this.streams = streams;
	}
	
	/**
	 * @return the 直播计划时间
	 */
	public List<JobJson> getJob() {
		return job;
	}
	
	/**
	 * @param 直播计划时间 the job to set
	 */
	public void setJob(List<JobJson> job) {
		this.job = job;
	}
	
}
