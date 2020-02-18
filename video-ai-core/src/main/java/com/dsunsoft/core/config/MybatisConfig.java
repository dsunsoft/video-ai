package com.dsunsoft.core.config;

import org.springframework.context.annotation.Bean;

import com.dsunsoft.core.interceptor.MybatisInterceptor;

/**
 * MybatisConfig
 * 
 * @author ygm
 *
 */
public class MybatisConfig {

	@Bean
	public MybatisInterceptor mybatisInterceptor() {
		return new MybatisInterceptor();
	}
}
