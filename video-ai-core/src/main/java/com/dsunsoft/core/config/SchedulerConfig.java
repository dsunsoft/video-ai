package com.dsunsoft.core.config;

import org.springframework.boot.autoconfigure.quartz.SchedulerFactoryBeanCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * 定时任务配置
 * @author ygm
 *
 */
@Configuration
public class SchedulerConfig implements SchedulerFactoryBeanCustomizer {

	@Override
	public void customize(SchedulerFactoryBean schedulerFactoryBean) {
		schedulerFactoryBean.setStartupDelay(5);
		schedulerFactoryBean.setAutoStartup(true);
		schedulerFactoryBean.setOverwriteExistingJobs(true);
	}

}
