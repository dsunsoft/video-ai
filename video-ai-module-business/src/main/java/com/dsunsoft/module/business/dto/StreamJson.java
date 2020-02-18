package com.dsunsoft.module.business.dto;

import java.io.Serializable;


/**
 * 乐橙云直播地址接口返回Streams
 * @author zb
 * @date 创建时间：2019年12月18日 下午5:05:14
 */
public class StreamJson implements Serializable {

	private static final long serialVersionUID = 1171987001098835371L;
	
	private String coverUrl;
	
	private Integer streamId;
	
	private String hls;

	/**
	 * @return the coverUrl
	 */
	public String getCoverUrl() {
		return coverUrl;
	}
	

	/**
	 * @param coverUrl the coverUrl to set
	 */
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
	

	/**
	 * @return the streamId
	 */
	public Integer getStreamId() {
		return streamId;
	}
	

	/**
	 * @param streamId the streamId to set
	 */
	public void setStreamId(Integer streamId) {
		this.streamId = streamId;
	}
	

	/**
	 * @return the hls
	 */
	public String getHls() {
		return hls;
	}
	

	/**
	 * @param hls the hls to set
	 */
	public void setHls(String hls) {
		this.hls = hls;
	}
	
	
	
	

}
