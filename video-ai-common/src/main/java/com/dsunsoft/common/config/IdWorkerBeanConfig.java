package com.dsunsoft.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.dsunsoft.common.util.IdWorker;

/**
 * IdWorkerBeanConfig
 * 
 * @author ygm
 *
 */
@Configuration
@Component
public class IdWorkerBeanConfig {

	@Value("${video-ai.idWorker.workerId}")
	private Integer workerId;

	@Value("${video-ai.idWorker.datacenterId}")
	private Integer datacenterId;

	@Bean
	public IdWorker getIdWorker() {
		return new IdWorker(workerId, datacenterId);
	}
}
