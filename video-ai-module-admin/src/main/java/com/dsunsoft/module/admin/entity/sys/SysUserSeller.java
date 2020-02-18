package com.dsunsoft.module.admin.entity.sys;

import com.dsunsoft.core.entity.BaseEntity;

public class SysUserSeller extends BaseEntity {
	private static final long serialVersionUID = -7759728656668495907L;
	private Integer sysUserSellerId;
	private String userId;
	private String sellerIds;
	private String sellerNames;

	private String userName;

	public Integer getSysUserSellerId() {
		return sysUserSellerId;
	}

	public void setSysUserSellerId(Integer sysUserSellerId) {
		this.sysUserSellerId = sysUserSellerId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSellerIds() {
		return sellerIds;
	}

	public void setSellerIds(String sellerIds) {
		this.sellerIds = sellerIds;
	}

	public String getSellerNames() {
		return sellerNames;
	}

	public void setSellerNames(String sellerNames) {
		this.sellerNames = sellerNames;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
