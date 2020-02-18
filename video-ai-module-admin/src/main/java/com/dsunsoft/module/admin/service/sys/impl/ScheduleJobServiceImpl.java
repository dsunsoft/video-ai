package com.dsunsoft.module.admin.service.sys.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsunsoft.common.util.IdWorker;
import com.dsunsoft.common.util.StringUtils;
import com.dsunsoft.core.service.BaseServiceImpl;
import com.dsunsoft.module.admin.dao.sys.ScheduleJobMapper;
import com.dsunsoft.module.admin.entity.sys.ScheduleJob;
import com.dsunsoft.module.admin.service.sys.ScheduleJobService;

@Service
public class ScheduleJobServiceImpl extends BaseServiceImpl<ScheduleJobMapper, ScheduleJob, String>
		implements ScheduleJobService {

	@Autowired
	private Scheduler scheduler;

	/**
	 * 保存
	 * 
	 * @param scheduleJob
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public void save(ScheduleJob scheduleJob) throws Exception {
		if (StringUtils.isBlank(scheduleJob.getId())) {
			scheduleJob.setId(IdWorker.getUuid());
			mapper.insert(scheduleJob);
		} else {
			ScheduleJob t = mapper.getById(scheduleJob.getId());
			JobKey key = new JobKey(t.getName(), t.getGroup());
			scheduler.deleteJob(key);
			mapper.update(scheduleJob);
		}
		//添加定时任务
		addJob(scheduleJob);
	}

	/**
	 * 删除任务
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	@Transactional(rollbackFor = Exception.class)
	public void delete(ScheduleJob scheduleJob) throws SchedulerException {
		JobKey key = new JobKey(scheduleJob.getName(), scheduleJob.getGroup());
		TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getName(), scheduleJob.getGroup());
		scheduler.pauseTrigger(triggerKey);
		scheduler.unscheduleJob(triggerKey);
		scheduler.deleteJob(key);
		mapper.deleteById(scheduleJob.getId());
	}

	/**
	 * 添加定时任务
	 * 
	 * @param scheduleJob
	 * @throws ClassNotFoundException
	 * @throws SchedulerException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addJob(ScheduleJob scheduleJob) throws ClassNotFoundException, SchedulerException {
		Class job = Class.forName(scheduleJob.getClassName());
		JobDetail jobDetail = JobBuilder.newJob(job).withIdentity(scheduleJob.getName(), scheduleJob.getGroup())
				.build();
		// 设置任务传递参数
		jobDetail.getJobDataMap().put("scheduleJob", scheduleJob);
		// 表达式调度构建器（可判断创建SimpleScheduleBuilder）
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());
		// 按新的cronExpression表达式构建一个新的触发器
		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(scheduleJob.getName(), scheduleJob.getGroup())
				.withSchedule(scheduleBuilder).build();
		// 将触发器与任务绑定到调度器内
		scheduler.scheduleJob(jobDetail, trigger);
		// 判断状态
		JobKey key = new JobKey(scheduleJob.getName(), scheduleJob.getGroup());
		if (scheduleJob.getStatus().equals("0")) {
			scheduler.pauseJob(key);
		} else {
			scheduler.resumeJob(key);
		}
	}

	/**
	 * 立即执行任务
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void startNowJob(ScheduleJob scheduleJob) throws SchedulerException {
		JobKey key = new JobKey(scheduleJob.getName(), scheduleJob.getGroup());
		scheduler.triggerJob(key);
	}

	/**
	 * 暂停任务
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void pauseJob(ScheduleJob scheduleJob) throws SchedulerException {
		JobKey key = new JobKey(scheduleJob.getName(), scheduleJob.getGroup());
		scheduler.pauseJob(key);
		scheduleJob.setStatus("0");
		mapper.update(scheduleJob);
	}

	/**
	 * 恢复任务
	 * 
	 * @param scheduleJob
	 * @throws SchedulerException
	 */
	public void resumeJob(ScheduleJob scheduleJob) throws SchedulerException {
		JobKey key = new JobKey(scheduleJob.getName(), scheduleJob.getGroup());
		scheduler.resumeJob(key);
		scheduleJob.setStatus("1");
		mapper.update(scheduleJob);
	}

	/**
	 * 获取所有计划中的任务
	 * 
	 * @return 结果集合
	 */
	public List<ScheduleJob> getJobList() {
		List<ScheduleJob> scheduleJobList = new ArrayList<ScheduleJob>();
		;
		GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
		try {
			Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
			for (JobKey jobKey : jobKeys) {
				List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
				for (Trigger trigger : triggers) {
					ScheduleJob scheduleJob = new ScheduleJob();
					scheduleJob.setName(jobKey.getName());
					scheduleJob.setGroup(jobKey.getGroup());
					Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
					scheduleJob.setStatus(triggerState.name());
					// 获取要执行的定时任务类名
					JobDetail jobDetail = scheduler.getJobDetail(jobKey);
					scheduleJob.setClassName(jobDetail.getJobClass().getName());
					// 判断trigger
					if (trigger instanceof SimpleTrigger) {
						SimpleTrigger simple = (SimpleTrigger) trigger;
						scheduleJob.setCronExpression(
								"重复次数:" + (simple.getRepeatCount() == -1 ? "无限" : simple.getRepeatCount()) + ",重复间隔:"
										+ (simple.getRepeatInterval() / 1000L));
						scheduleJob.setDescription(simple.getDescription());
					}
					if (trigger instanceof CronTrigger) {
						CronTrigger cron = (CronTrigger) trigger;
						scheduleJob.setCronExpression(cron.getCronExpression());
						scheduleJob.setDescription(
								cron.getDescription() == null ? ("触发器:" + trigger.getKey()) : cron.getDescription());
					}
					scheduleJobList.add(scheduleJob);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scheduleJobList;
	}

	/**
	 * 获取所有运行中的任务
	 * 
	 * @return 结果集合
	 */
	public List<ScheduleJob> getRuningJobList() {
		List<ScheduleJob> scheduleJobList = new ArrayList<>();
		try {
			List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
			scheduleJobList = new ArrayList<ScheduleJob>(executingJobs.size());
			for (JobExecutionContext executingJob : executingJobs) {
				ScheduleJob scheduleJob = new ScheduleJob();
				JobDetail jobDetail = executingJob.getJobDetail();
				JobKey jobKey = jobDetail.getKey();
				Trigger trigger = executingJob.getTrigger();
				scheduleJob.setName(jobKey.getName());
				scheduleJob.setGroup(jobKey.getGroup());
				// scheduleJob.setDescription("触发器:" + trigger.getKey());
				Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
				scheduleJob.setStatus(triggerState.name());
				// 获取要执行的定时任务类名
				scheduleJob.setClassName(jobDetail.getJobClass().getName());
				// 判断trigger
				if (trigger instanceof SimpleTrigger) {
					SimpleTrigger simple = (SimpleTrigger) trigger;
					scheduleJob.setCronExpression(
							"重复次数:" + (simple.getRepeatCount() == -1 ? "无限" : simple.getRepeatCount()) + ",重复间隔:"
									+ (simple.getRepeatInterval() / 1000L));
					scheduleJob.setDescription(simple.getDescription());
				}
				if (trigger instanceof CronTrigger) {
					CronTrigger cron = (CronTrigger) trigger;
					scheduleJob.setCronExpression(cron.getCronExpression());
					scheduleJob.setDescription(cron.getDescription());
				}
				scheduleJobList.add(scheduleJob);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
			logger.error("getRuningJobList error:" + e.getMessage());
		}
		return scheduleJobList;
	}

	/**
	 * 获取所有getJobDetailList
	 * 
	 * @return 结果集合
	 */
	public List<JobDetail> getJobDetailList() {
		List<JobDetail> jobDetails = new ArrayList<>();
		try {
			GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
			Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
			for (JobKey key : jobKeys) {
				jobDetails.add(scheduler.getJobDetail(key));
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
			logger.error("getJobDetailList error:" + e.getMessage());
		}
		return jobDetails;
	}

	/**
	 * 获取所有的触发器
	 * 
	 * @return 结果集合
	 */
	public List<ScheduleJob> getTriggersInfoList() {
		List<ScheduleJob> triggers = new ArrayList<>();
		try {
			GroupMatcher<TriggerKey> matcher = GroupMatcher.anyTriggerGroup();
			Set<TriggerKey> Keys = scheduler.getTriggerKeys(matcher);
			for (TriggerKey key : Keys) {
				Trigger trigger = scheduler.getTrigger(key);
				ScheduleJob scheduleJob = new ScheduleJob();
				scheduleJob.setName(trigger.getJobKey().getName());
				scheduleJob.setGroup(trigger.getJobKey().getGroup());
				scheduleJob.setStatus(scheduler.getTriggerState(key) + "");
				if (trigger instanceof SimpleTrigger) {
					SimpleTrigger simple = (SimpleTrigger) trigger;
					scheduleJob.setCronExpression(
							"重复次数:" + (simple.getRepeatCount() == -1 ? "无限" : simple.getRepeatCount()) + ",重复间隔:"
									+ (simple.getRepeatInterval() / 1000L));
					scheduleJob.setDescription(simple.getDescription());
				}
				if (trigger instanceof CronTrigger) {
					CronTrigger cron = (CronTrigger) trigger;
					scheduleJob.setCronExpression(cron.getCronExpression());
					scheduleJob.setDescription(cron.getDescription());
				}
				triggers.add(scheduleJob);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
			logger.error("getTriggersInfoList error:" + e.getMessage());
		}
		return triggers;
	}
}
