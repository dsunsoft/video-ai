package com.dsunsoft.common.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
	private static final char SEPARATOR = '_';
	private static final String CHARSET_NAME = "UTF-8";
	private static Pattern linePattern = Pattern.compile("_(\\w)");
	private static Pattern humpPattern = Pattern.compile("[A-Z]");

	/**
	 * 转换为字节数组
	 *
	 * @param str
	 * @return
	 */
	public static byte[] getBytes(String str) {
		if (str != null) {
			try {
				return str.getBytes(CHARSET_NAME);
			} catch (UnsupportedEncodingException e) {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * 转换为字节数组
	 *
	 * @param str
	 * @return
	 */
	public static String toString(byte[] bytes) {
		try {
			return new String(bytes, CHARSET_NAME);
		} catch (UnsupportedEncodingException e) {
			return EMPTY;
		}
	}

	/**
	 * 是否包含字符串
	 *
	 * @param str
	 *            验证字符串
	 * @param strs
	 *            字符串组
	 * @return 包含返回true
	 */
	public static boolean inString(String str, String... strs) {
		if (str != null) {
			for (String s : strs) {
				if (str.equals(trim(s))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 驼峰命名法工具
	 *
	 * @return toCamelCase(" hello_world ") == "helloWorld"
	 *         toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 *         toUnderScoreCase("helloWorld") = "hello_world"
	 */
	public static String toCamelCase(String s) {
		if (s == null) {
			return null;
		}

		s = s.toLowerCase();

		StringBuilder sb = new StringBuilder(s.length());
		boolean upperCase = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == SEPARATOR) {
				upperCase = true;
			} else if (upperCase) {
				sb.append(Character.toUpperCase(c));
				upperCase = false;
			} else {
				sb.append(c);
			}
		}

		return sb.toString();
	}

	/**
	 * 驼峰命名法工具
	 *
	 * @return toCamelCase(" hello_world ") == "helloWorld"
	 *         toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 *         toUnderScoreCase("helloWorld") = "hello_world"
	 */
	public static String toCapitalizeCamelCase(String s) {
		if (s == null) {
			return null;
		}
		s = toCamelCase(s);
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	/**
	 * 驼峰命名法工具
	 *
	 * @return toCamelCase(" hello_world ") == "helloWorld"
	 *         toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 *         toUnderScoreCase("helloWorld") = "hello_world"
	 */
	public static String toUnderScoreCase(String s) {
		if (s == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		boolean upperCase = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			boolean nextUpperCase = true;

			if (i < (s.length() - 1)) {
				nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
			}

			if ((i > 0) && Character.isUpperCase(c)) {
				if (!upperCase || !nextUpperCase) {
					sb.append(SEPARATOR);
				}
				upperCase = true;
			} else {
				upperCase = false;
			}

			sb.append(Character.toLowerCase(c));
		}

		return sb.toString();
	}

	/**
	 * 如果不为空，则设置值
	 *
	 * @param target
	 * @param source
	 */
	public static void setValueIfNotBlank(String target, String source) {
		if (isNotBlank(source)) {
			target = source;
		}
	}

	/**
	 * @param target
	 * @param source
	 */
	public static int lastIndexOf(String target, String str) {
		if (isBlank(target) || isBlank(str)) {
			return -1;
		}
		return target.lastIndexOf(str);
	}

	/**
	 * 下划线转驼峰
	 *
	 * @param str
	 * @return
	 */
	public static String lineToHump(String str) {
		if (null == str || "".equals(str)) {
			return str;
		}
		str = str.toLowerCase();
		Matcher matcher = linePattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
		}
		matcher.appendTail(sb);

		str = sb.toString();
		str = str.substring(0, 1).toUpperCase() + str.substring(1);

		return str;
	}

	/**
	 * 驼峰转下划线,效率比上面高
	 *
	 * @param str
	 * @return
	 */
	public static String humpToLine(String str) {
		Matcher matcher = humpPattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 驼峰转下划线(简单写法，效率低于{@link #humpToLine(String)})
	 *
	 * @param str
	 * @return
	 */
	public static String humpToLine2(String str) {
		return str.replaceAll("[A-Z]", "_$0").toLowerCase();
	}

	/**
	 * 首字母转小写
	 *
	 * @param s
	 * @return
	 */
	public static String toLowerCaseFirstOne(String s) {
		if (StringUtils.isBlank(s)) {
			return s;
		}
		if (Character.isLowerCase(s.charAt(0))) {
			return s;
		} else {
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
		}
	}

	/**
	 * 首字母转大写
	 *
	 * @param s
	 * @return
	 */
	public static String toUpperCaseFirstOne(String s) {
		if (StringUtils.isBlank(s)) {
			return s;
		}
		if (Character.isUpperCase(s.charAt(0))) {
			return s;
		} else {
			return (new StringBuffer()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
		}
	}

	public static String subBefore(CharSequence string, CharSequence separator, boolean isLastSeparator) {
		if (!isEmpty(string) && separator != null) {
			String str = string.toString();
			String sep = separator.toString();
			if (sep.isEmpty()) {
				return "";
			} else {
				int pos = isLastSeparator ? str.lastIndexOf(sep) : str.indexOf(sep);
				if (-1 == pos) {
					return str;
				} else {
					return 0 == pos ? "" : str.substring(0, pos);
				}
			}
		} else {
			return null == string ? null : string.toString();
		}
	}

	public static String subBefore(CharSequence string, char separator, boolean isLastSeparator) {
		if (isEmpty(string)) {
			return null == string ? null : string.toString();
		} else {
			String str = string.toString();
			int pos = isLastSeparator ? str.lastIndexOf(separator) : str.indexOf(separator);
			if (-1 == pos) {
				return str;
			} else {
				return 0 == pos ? "" : str.substring(0, pos);
			}
		}
	}

	public static String subAfter(CharSequence string, CharSequence separator, boolean isLastSeparator) {
		if (isEmpty(string)) {
			return null == string ? null : string.toString();
		} else if (separator == null) {
			return "";
		} else {
			String str = string.toString();
			String sep = separator.toString();
			int pos = isLastSeparator ? str.lastIndexOf(sep) : str.indexOf(sep);
			return -1 != pos && string.length() - 1 != pos ? str.substring(pos + separator.length()) : "";
		}
	}

	public static String subAfter(CharSequence string, char separator, boolean isLastSeparator) {
		if (isEmpty(string)) {
			return null == string ? null : string.toString();
		} else {
			String str = string.toString();
			int pos = isLastSeparator ? str.lastIndexOf(separator) : str.indexOf(separator);
			return -1 == pos ? "" : str.substring(pos + 1);
		}
	}

	public static String subBetween(CharSequence str, CharSequence before, CharSequence after) {
		if (str != null && before != null && after != null) {
			String str2 = str.toString();
			String before2 = before.toString();
			String after2 = after.toString();
			int start = str2.indexOf(before2);
			if (start != -1) {
				int end = str2.indexOf(after2, start + before2.length());
				if (end != -1) {
					return str2.substring(start + before2.length(), end);
				}
			}

			return null;
		} else {
			return null;
		}
	}
}
