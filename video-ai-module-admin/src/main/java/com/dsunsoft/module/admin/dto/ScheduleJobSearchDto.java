package com.dsunsoft.module.admin.dto;

import com.dsunsoft.core.entity.BaseSearchDto;

public class ScheduleJobSearchDto extends BaseSearchDto {
	private static final long serialVersionUID = -8053693909178470071L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
