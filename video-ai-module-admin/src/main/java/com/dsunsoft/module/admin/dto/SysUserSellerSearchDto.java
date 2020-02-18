package com.dsunsoft.module.admin.dto;

import com.dsunsoft.core.entity.BaseSearchDto;

public class SysUserSellerSearchDto extends BaseSearchDto {
	private static final long serialVersionUID = 7914610602786554250L;
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
