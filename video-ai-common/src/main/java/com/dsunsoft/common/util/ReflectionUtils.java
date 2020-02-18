package com.dsunsoft.common.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 反射工具类
 * 
 * @author ygm
 *
 */
public class ReflectionUtils {

	/**
	 * 实体对象转成Map
	 * 
	 * @param obj
	 * @return
	 */
	public static <T> Map<String, Object> parseMap(T obj) {
		Map<String, Object> map = new HashMap<>();
		if (obj == null) {
			return map;
		}
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		try {
			for (Field field : fields) {
				field.setAccessible(true);
				map.put(field.getName(), field.get(obj));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
