package com.dsunsoft.core.config;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.dsunsoft.common.constant.CommonConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * WebMvcConfig
 *
 * @author ygm
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

	@Autowired
	private UploadConfig uploadConfig;

//	/**
//	 * 定义时间格式转换器
//	 * 
//	 * @return
//	 */
//	@Bean
//	public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//		ObjectMapper mapper = new ObjectMapper();
//		// 日期格式
//		mapper.setTimeZone(TimeZone.getTimeZone(CommonConstants.TIME_ZONE));
//		mapper.setDateFormat(new SimpleDateFormat(CommonConstants.DATE_FORMAT));
//		// 设置空如何序列化
//		mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
//		// 忽略json中不存在的属性
//		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		// 允许出现单引号
//		mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
//		converter.setObjectMapper(mapper);
//		return converter;
//	}

	/**
	 * 继承了WebMvcConfigurationSupport, 需要重新指定静态资源
	 *
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		/// uploads/ 映射到D盘的uploads文件夹下
		registry.addResourceHandler(uploadConfig.getRelativeUrl() + "**")
				.addResourceLocations("file:" + uploadConfig.getPath());
		// swagger-ui
		registry.addResourceHandler("/**").addResourceLocations("/classpath:/static/");
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		super.addResourceHandlers(registry);
	}

	/**
	 * 添加转换器 继承了WebMvcConfigurationSupport会覆盖 spring.jackson 配置,会导致无效,需要重写转换方法
	 */
//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		// 添加自定义的时间格式转换器添加到转换器列表中
//		converters.add(jackson2HttpMessageConverter());
//	}

	/**
	 * url忽略大小写
	 */
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		AntPathMatcher matcher = new AntPathMatcher();
		matcher.setCaseSensitive(false);
		configurer.setPathMatcher(matcher);
	}

	/**
	 * 跨域CORS配置
	 *
	 * @param registry
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		super.addCorsMappings(registry);
		registry.addMapping("/cors/**").allowedHeaders("*").allowedMethods("POST", "GET", "PUT", "DELETE")
				.allowedOrigins("*");
	}
}
