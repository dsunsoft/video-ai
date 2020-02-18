package com.dsunsoft.module.admin.dto;

import com.dsunsoft.core.entity.BaseSearchDto;

/**
 * 数据字典Entity
 * 
 * @author zd
 */
public class DictTypeSearchDto extends BaseSearchDto {
	private static final long serialVersionUID = 1L;
	private String type; // 类型
	private String description; // 描述

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}