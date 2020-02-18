package com.dsunsoft.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

import com.dsunsoft.core.config.VideoAiConfig;
import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;

/**
 * 只作为启动项 video-ai-module-*
 * @author zb
 */
@EnableCaching
@SpringBootApplication(scanBasePackages = "com.dsunsoft",exclude = PageHelperAutoConfiguration.class)
//@SpringBootApplication(scanBasePackages = "com.dsunsoft")
//@MapperScan("com.dsunsoft.module.*.dao")
@EnableConfigurationProperties({VideoAiConfig.class})
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}