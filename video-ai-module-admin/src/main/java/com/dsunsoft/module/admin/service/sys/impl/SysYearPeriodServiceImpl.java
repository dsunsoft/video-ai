package com.dsunsoft.module.admin.service.sys.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsunsoft.common.constant.WebConstants;
import com.dsunsoft.core.service.BaseServiceImpl;
import com.dsunsoft.module.admin.dao.sys.SysYearPeriodMapper;
import com.dsunsoft.module.admin.entity.sys.SysYearPeriod;
import com.dsunsoft.module.admin.service.sys.SysYearPeriodService;

@Service
public class SysYearPeriodServiceImpl extends BaseServiceImpl<SysYearPeriodMapper, SysYearPeriod, Integer>
		implements SysYearPeriodService {

	@Override
	public SysYearPeriod getByYearPeriod(Integer yearPeriod) {
		return mapper.getByYearPeriod(yearPeriod);
	}

	@Transactional
	@Override
	public void save(SysYearPeriod sysYearPeriod) {
		if (null == sysYearPeriod.getSysYearPeriodId()
				|| WebConstants.NO_INT.equals(sysYearPeriod.getSysYearPeriodId())) {
			mapper.insert(sysYearPeriod);
		} else {
			mapper.update(sysYearPeriod);
		}
	}

	@Override
	public Integer getNowPeriod() {
		return mapper.getNowPeriod();
	}

	@Override
	public List<Integer> getPeriodList() {
		return mapper.getPeriodList();
	}

	/**
	 * @Title: carryPeriod
	 * @Description: 创建月度分表 返回类型 @throws
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void carryPeriod() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		Integer nowPeriod = Integer.parseInt(year + String.valueOf(month < 10 ? "0" + month : month));
		String userId = WebConstants.ADMIN_USER_ID;
		// 新增新区间记录
		Date date = new Date();
		SysYearPeriod period = mapper.getByYearPeriod(nowPeriod);
		if (period == null) {
			period = new SysYearPeriod();
			period.setYearId(year);
			period.setMonthId(month);
			period.setYearPeriod(nowPeriod);
			period.setCarryDate(date);
			period.setCreateDate(date);
			period.setCreateBy(userId);
			period.setUpdateBy(userId);
			period.setUpdateDate(date);
			mapper.insert(period);
		}
		// 上个月度
		Integer lastYearPeriod = mapper.getLastYearPeriod();
		// 创建年月表
		mapper.createTable(userId, nowPeriod, lastYearPeriod);
	}

	@Override
	public List<Integer> getYearPeriodRange(Date startYearPeriod, Date endYearPeriod) {
		return mapper.getYearPeriodRange(startYearPeriod, endYearPeriod);
	}

	@Override
	public List<Integer> getYearList() {
		return mapper.getYearList();
	}
}
