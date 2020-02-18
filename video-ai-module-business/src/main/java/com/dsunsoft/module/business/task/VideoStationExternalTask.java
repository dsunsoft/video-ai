package com.dsunsoft.module.business.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dsunsoft.module.business.external.VideoStationInterface;

/**
 * 视屏接口调用定时器
 * @author zb
 * @date 创建时间：2019年9月18日 下午4:19:55
 */
public class VideoStationExternalTask implements Job {

	private static Logger log = LoggerFactory.getLogger(VideoStationExternalTask.class); 
	
    @Autowired
    private VideoStationInterface videoStationService;
	
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			log.info("开始启动视屏接口调用定时器！");
			videoStationService.syncData();
			log.info("结束启动视屏信息接口调用定时器！");
		} catch (Exception e) {
			log.error("逐日视屏信息接口调用定时器异常:" + e.getMessage());
		}
	}

}
