package com.dsunsoft.module.admin.entity.sys;

import java.util.Date;

import com.dsunsoft.core.entity.BaseEntity;

public class SysYearPeriod extends BaseEntity {
	private static final long serialVersionUID = 2269292942347806333L;

	private Integer sysYearPeriodId; // sys_year_period_id
	private Integer yearId; // 年度
	private Integer monthId; // 月度
	private Integer yearPeriod; // 年月
	private Date carryDate; // 结转时间

	public Integer getSysYearPeriodId() {
		return sysYearPeriodId;
	}

	public void setSysYearPeriodId(Integer sysYearPeriodId) {
		this.sysYearPeriodId = sysYearPeriodId;
	}

	public Integer getYearId() {
		return yearId;
	}

	public void setYearId(Integer yearId) {
		this.yearId = yearId;
	}

	public Integer getMonthId() {
		return monthId;
	}

	public void setMonthId(Integer monthId) {
		this.monthId = monthId;
	}

	public Integer getYearPeriod() {
		return yearPeriod;
	}

	public void setYearPeriod(Integer yearPeriod) {
		this.yearPeriod = yearPeriod;
	}

	public Date getCarryDate() {
		return carryDate;
	}

	public void setCarryDate(Date carryDate) {
		this.carryDate = carryDate;
	}

}
