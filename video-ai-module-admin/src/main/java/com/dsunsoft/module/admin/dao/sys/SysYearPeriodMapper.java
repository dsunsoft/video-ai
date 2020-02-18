package com.dsunsoft.module.admin.dao.sys;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dsunsoft.core.dao.BaseMapper;
import com.dsunsoft.module.admin.entity.sys.SysYearPeriod;

public interface SysYearPeriodMapper extends BaseMapper<SysYearPeriod, Integer> {

	SysYearPeriod getByYearPeriod(Integer yearPeriod);

	Integer getNowPeriod();

	List<Integer> getPeriodList();

	void createTable(@Param("userId") String userId, @Param("yearPeriod") Integer yearPeriod,
			@Param("lastYearPeriod") Integer lastYearPeriod);

	Integer getLastYearPeriod();

	List<Integer> getYearPeriodRange(@Param("startYearPeriod") Date startYearPeriod,
			@Param("endYearPeriod") Date endYearPeriod);
	
	List<Integer> getYearList();
}
