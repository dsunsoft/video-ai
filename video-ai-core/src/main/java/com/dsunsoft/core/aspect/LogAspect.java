package com.dsunsoft.core.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import com.dsunsoft.common.util.JsonUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 日志拦截器
 *
 * @author ygm
 */
@Aspect
@Component
public class LogAspect {
	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
	private ThreadLocal<Long> threadLocal = new ThreadLocal<>();

	@Pointcut("execution(* com.dsunsoft.module.*.web.*.*(..)) || execution(* com.dsunsoft.web.api.web.*.*(..))")
	public void webLog() {
	}

	/**
	 * 前置通知，目标方法调用前被调用
	 * 
	 * @param joinPoint
	 */
	@Before("webLog()")
	public void dobefore(JoinPoint joinPoint) {
		if (logger.isDebugEnabled()) {
			threadLocal.set(System.currentTimeMillis());
			// 接收到请求，记录请求内容
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpServletRequest request = attributes.getRequest();
			logger.debug("计时开始: url:{}  http_method:{}  ip:{}  class_method:{}  args:{}",
					request.getRequestURL().toString(), request.getMethod(), request.getRemoteAddr(),
					joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),
					Arrays.toString(joinPoint.getArgs()));
		}
	}

	/**
	 * 后置最终通知，目标方法执行完执行
	 */
	@AfterReturning(returning = "res", pointcut = "webLog()")
	public void doAfterReturning(Object res) throws Throwable {
		if (logger.isDebugEnabled()) {
			// 处理完请求，返回内容
			String result = "";
			if (null != res) {
				result = res.toString();// JsonUtils.toJson(res);
			}
			logger.debug("计时结束 : 耗时 :{}  返回结果:{} ", ((System.currentTimeMillis() - threadLocal.get())) + "ms", result);
		}
	}
}