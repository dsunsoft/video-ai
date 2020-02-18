package com.dsunsoft.module.admin.dto;

import com.dsunsoft.core.entity.BaseSearchDto;

/**
 * SysYearPeriodSearchDto
 * 
 * @author ygm
 *
 */
public class SysYearPeriodSearchDto extends BaseSearchDto {
	private static final long serialVersionUID = -2543220882082791964L;

	private Integer yearPeriod;

	public Integer getYearPeriod() {
		return yearPeriod;
	}

	public void setYearPeriod(Integer yearPeriod) {
		this.yearPeriod = yearPeriod;
	}

}
