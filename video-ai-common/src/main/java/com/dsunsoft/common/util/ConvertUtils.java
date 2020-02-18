package com.dsunsoft.common.util;

import java.util.regex.Pattern;

/**
 * 数据类型转换
 * 
 * @author ygm
 *
 */
public class ConvertUtils {
	private static Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
	private static Pattern DOUBLE_PATTERN = Pattern.compile("^[0-9]*(\\.?)[0-9]*$");

	/**
	 * 转换为Double类型
	 */
	public static Double toDouble(Object val) {
		if (val == null) {
			return 0D;
		}
		try {
			return Double.valueOf(StringUtils.trim(val.toString()));
		} catch (Exception e) {
			return 0D;
		}
	}

	/**
	 * 转换为Float类型
	 */
	public static Float toFloat(Object val) {
		return toDouble(val).floatValue();
	}

	/**
	 * 转换为Long类型
	 */
	public static Long toLong(Object val) {
		return toDouble(val).longValue();
	}

	/**
	 * 转换为Integer类型
	 */
	public static Integer toInteger(Object val) {
		return toLong(val).intValue();
	}

	/**
	 * 校验整数
	 * 
	 * @param num
	 * @return
	 */
	public static boolean isInteger(String num) {
		return NUMBER_PATTERN.matcher(num).matches();
	}

	/**
	 * 校验小数或整数
	 * 
	 * @param num
	 * @return
	 */
	public static boolean isDouble(String num) {
		return DOUBLE_PATTERN.matcher(num).matches();
	}
}
