package com.dsunsoft.module.admin.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SysUserSellerDto implements Serializable {
	private static final long serialVersionUID = 5527080471973838083L;

	private Integer sysUserSellerId;
	@NotNull(message = "操作员不能为空")
	private String userId;
	@NotBlank(message = "客户不能为空")
	private String sellerIds;
	private String sellerNames;
	private String remarks;

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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
