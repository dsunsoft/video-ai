package com.dsunsoft.module.admin.service.sys;

import org.quartz.SchedulerException;

import com.dsunsoft.core.service.BaseService;
import com.dsunsoft.module.admin.entity.sys.ScheduleJob;

public interface ScheduleJobService extends BaseService<ScheduleJob, String> {
	void save(ScheduleJob scheduleJob) throws Exception;

	void delete(ScheduleJob scheduleJob) throws SchedulerException;

	void startNowJob(ScheduleJob scheduleJob) throws SchedulerException;

	void pauseJob(ScheduleJob scheduleJob) throws SchedulerException;

	void resumeJob(ScheduleJob scheduleJob) throws SchedulerException;

}
