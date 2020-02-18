package com.dsunsoft.module.admin.task;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dsunsoft.module.admin.entity.sys.ScheduleJob;

/**
 * 定时任务测试
 * 
 * @author ygm
 *
 */
public class TestTask implements Job {
	private static final Logger logger = LoggerFactory.getLogger(TestTask.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("测试定时任务开始。。。");
		// 获取任务详情内的数据集合
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		//spring boot 热部署会出现 java.lang.ClassCastException 异常,暂不使用
		//ScheduleJob scheduleJob = (ScheduleJob) dataMap.get("scheduleJob");
		System.out.println(dataMap);
		logger.info("测试定时任务完成。。。");
	}

}
