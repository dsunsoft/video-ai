package com.dsunsoft.module.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

import com.dsunsoft.core.config.VideoAiConfig;
import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;

@EnableCaching
//@SpringBootApplication(scanBasePackages = "com.dsunsoft")
//@MapperScan("com.dsunsoft.module.admin.dao")
@SpringBootApplication(scanBasePackages = "com.dsunsoft",exclude = PageHelperAutoConfiguration.class)
@EnableConfigurationProperties({VideoAiConfig.class})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}