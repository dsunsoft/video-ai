package com.dsunsoft.module.business.entity;

import com.dsunsoft.core.entity.BaseEntity;
import lombok.Data;

/**
 * @author zb
 * 视频实时数据
 */
@Data
public class VideoStation extends BaseEntity{

	
	private static final long serialVersionUID = 1L;
	
	private String id;
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
     * 任务周期
     */
    private String period;
    /**
     *  [bool]直播计划状态（true:开；false:关）
     */
    private String status;
    /**
     * 视频封面更新频率（单位：s）
     */
    private Integer coverUpdate;
    /**
     * 封面图片地址
     */
	private String coverUrl;
	/**
	 * 直播流hls访问地址
	 */
	private String hls;
	/**
	 * [int]码流类型（0:主码流；1:辅码流）(当直播地址由rtsp源生成时，无该字段)
	 */
	private Integer streamId;
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
	 * @return the 任务周期
	 */
	public String getPeriod() {
		return period;
	}
	
	/**
	 * @param 任务周期 the period to set
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	
	/**
	 * @return the [bool]直播计划状态（true:开；false:关）
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * @param [bool]直播计划状态（true:开；false:关） the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the 封面图片地址
	 */
	public String getCoverUrl() {
		return coverUrl;
	}
	
	/**
	 * @param 封面图片地址 the coverUrl to set
	 */
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
	
	/**
	 * @return the 直播流hls访问地址
	 */
	public String getHls() {
		return hls;
	}
	
	/**
	 * @param 直播流hls访问地址 the 直播流hls访问地址 to set
	 */
	public void setHls(String hls) {
		this.hls = hls;
	}
	
	/**
	 * @return the [int]码流类型（0:主码流；1:辅码流）(当直播地址由rtsp源生成时，无该字段)
	 */
	public Integer getStreamId() {
		return streamId;
	}
	
	/**
	 * @param [int]码流类型（0:主码流；1:辅码流）(当直播地址由rtsp源生成时，无该字段) the streamId to set
	 */
	public void setStreamId(Integer streamId) {
		this.streamId = streamId;
	}
	
	
	
	
}
