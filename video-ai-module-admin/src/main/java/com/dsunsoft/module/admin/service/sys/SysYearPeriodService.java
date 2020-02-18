package com.dsunsoft.module.admin.service.sys;

import java.util.Date;
import java.util.List;

import com.dsunsoft.core.service.BaseService;
import com.dsunsoft.module.admin.entity.sys.SysYearPeriod;

public interface SysYearPeriodService extends BaseService<SysYearPeriod, Integer> {

	SysYearPeriod getByYearPeriod(Integer yearPeriod);

	void save(SysYearPeriod sysYearPeriod);

	Integer getNowPeriod();

	List<Integer> getPeriodList();

	void carryPeriod();

	List<Integer> getYearPeriodRange(Date startYearPeriod, Date endYearPeriod);
	
	List<Integer> getYearList();
}
