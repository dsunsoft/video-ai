package com.dsunsoft.core.interceptor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dsunsoft.core.util.SecurityUtils;

@Component
@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) })
public class MybatisInterceptor implements Interceptor {
	private static final Logger logger = LoggerFactory.getLogger(MybatisInterceptor.class);
	/** 创建人 */
	private static final String CREATE_BY = "createBy";
	/** 创建时间 */
	private static final String CREATE_DATE = "createDate";
	/** 最后修改人 */
	private static final String UPDATE_BY = "updateBy";
	/** 最后修改时间 */
	private static final String UPDATE_DATE = "updateDate";
	/** 是否被删除 */
	private static final String DEL_FLAG = "delFlag";
	private static final String DEFAULT_DEL_FLAG = "0";

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
		SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
		Object parameter = invocation.getArgs()[1];
		// Field[] fields = parameter.getClass().getDeclaredFields();
		List<Field> fieldList = new ArrayList<>();
		Class tempClass = parameter.getClass();
		while (null != tempClass) {
			fieldList.addAll(Arrays.asList(tempClass.getDeclaredFields()));
			tempClass = tempClass.getSuperclass();
		}
		Date currentDate = new Date();
		if (SqlCommandType.UPDATE == sqlCommandType) {
			for (Field field : fieldList) {
				if (UPDATE_BY.equals(field.getName())) {
					field.setAccessible(true);
					if (null == field.get(parameter)) {
						field.set(parameter, SecurityUtils.getCurrentUserLogin());
					}
					field.setAccessible(false);
				}
				if (UPDATE_DATE.equals(field.getName())) {
					setValue(parameter, field, currentDate);
				}
				// 更新和删除都会执行此方法，但是如果这个字段是null的话，那么设置为0
				// 如果是删除的话，设置为0可能会有bug，本来应该设置为1的，如果是删除原来的代码肯定是要设置为1的，否则单元测试过不了，所以可以忽略这种情况
				if (DEL_FLAG.equals(field.getName())) {
					field.setAccessible(true);
					if (null == field.get(parameter)) {
						field.set(parameter, DEFAULT_DEL_FLAG);
					}
					field.setAccessible(false);
				}
			}
		} else if (SqlCommandType.INSERT == sqlCommandType) {
			for (Field field : fieldList) {
				if (CREATE_BY.equals(field.getName())) {
					field.setAccessible(true);
					if (null == field.get(parameter)) {
						field.set(parameter, SecurityUtils.getCurrentUserLogin());
					}
					field.setAccessible(false);
				}
				if (CREATE_DATE.equals(field.getName())) {
					setValue(parameter, field, currentDate);
				}
				if (UPDATE_BY.equals(field.getName())) {
					field.setAccessible(true);
					if (null == field.get(parameter)) {
						field.set(parameter, SecurityUtils.getCurrentUserLogin());
					}
					field.setAccessible(false);
				}
				if (UPDATE_DATE.equals(field.getName())) {
					setValue(parameter, field, currentDate);
				}
				if (DEL_FLAG.equals(field.getName())) {
					setValue(parameter, field, DEFAULT_DEL_FLAG);
				}
			}
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
	}

	/**
	 * 设置属性值
	 * 
	 * @param parameter
	 * @param field
	 * @param value
	 * @throws IllegalAccessException
	 */
	private void setValue(Object parameter, Field field, Object value) throws IllegalAccessException {
		field.setAccessible(true);
		if (null == field.get(parameter)) {
			field.set(parameter, value);
		}
		field.setAccessible(false);
	}

}
