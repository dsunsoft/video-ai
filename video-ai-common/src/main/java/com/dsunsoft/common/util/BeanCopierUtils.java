package com.dsunsoft.common.util;

import org.springframework.cglib.beans.BeanCopier;

/**
 * 对象复制 
 * 1.属性名称和类型必须一致才复制 
 * 2.如果不一样则需要自定义转换器(实现 Converter)
 * 
 * @author ygm
 *
 */
public class BeanCopierUtils {

	/**
	 * 对象复制
	 * 
	 * @param source
	 * @param target
	 */
	public static <S, T> void copy(S source, T target) {
		BeanCopier copier = BeanCopier.create(source.getClass(), target.getClass(), false);
		copier.copy(source, target, null);
	}
}
