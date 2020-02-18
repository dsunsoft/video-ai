package com.dsunsoft.common.util;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取Spring上下文对象
 * 
 * @author ygm
 *
 */
@Component
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {
	private static final Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);
	/**
	 * 上下文对象实例
	 */
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		logger.debug("ApplicationContext registed-->{}", applicationContext);
		SpringContextHolder.applicationContext = applicationContext;
	}

	/**
	 * 获取applicationContext
	 * 
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		assertContextInjected();
		return applicationContext;
	}

	/**
	 * 通过name获取 Bean
	 * 
	 * @param name
	 * @return
	 * @throws BeansException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) throws BeansException {
		assertContextInjected();
		return (T) applicationContext.getBean(name);
	}

	/**
	 * 通过class获取Bean
	 * 
	 * @param type
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz) {
		assertContextInjected();
		return applicationContext.getBean(clazz);
	}

	/**
	 * 通过name,以及Clazz返回指定的Bean
	 * 
	 * @param name
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public <T> T getBean(String name, Class<T> clazz) {
		assertContextInjected();
		return getApplicationContext().getBean(name, clazz);
	}

	/**
	 * 获取 jwtSigningKey
	 */
	public static String getJwtSigningKey() {
		return getApplicationContext().getEnvironment().getProperty("wms.oauth2.jwtSigningKey");
	}
	
	@Override
	public void destroy() throws Exception {
		applicationContext = null;
		logger.debug("清除SpringContextHolder中的ApplicationContext:" + applicationContext);
	}

	/**
	 * 获取当前环境
	 */
	public static String getActiveProfile() {
		return getApplicationContext().getEnvironment().getActiveProfiles()[0];
	}

	/**
	 * 检查ApplicationContext不为空.
	 */
	private static void assertContextInjected() {
		Validate.validState(applicationContext != null, "applicaitonContext属性为null,请检查是否注入了SpringContextHolder!");
	}
}
