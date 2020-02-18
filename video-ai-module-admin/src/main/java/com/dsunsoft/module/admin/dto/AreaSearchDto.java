package com.dsunsoft.module.admin.dto;

import com.dsunsoft.core.entity.BaseSearchDto;

public class AreaSearchDto extends BaseSearchDto {
	private static final long serialVersionUID = 5490463297645384077L;

	private Integer type;
	private String parentCode;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

}
