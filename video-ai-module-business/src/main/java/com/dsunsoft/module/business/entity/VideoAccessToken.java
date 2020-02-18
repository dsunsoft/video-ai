package com.dsunsoft.module.business.entity;

import java.util.Date;

import com.dsunsoft.core.entity.BaseEntity;

/**
 * @author zb 获取乐橙云accessToken
 */
public class VideoAccessToken extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String id;

	/**
	 * token信息
	 */
	private String accessToken;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 过期时间（7天）
	 */
	private Long expireTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}

	@Override
	public String toString() {
		return "VideoAccessToken [id=" + id + ", accessToken=" + accessToken + ", createDate=" + createDate
				+ ", expireTime=" + expireTime + "]";
	}
}
