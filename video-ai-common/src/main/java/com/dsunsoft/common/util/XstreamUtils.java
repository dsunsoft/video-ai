package com.dsunsoft.common.util;

import java.util.Map;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.LongConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.mapper.DefaultMapper;

/**
 * xml转换工具类
 */
public class XstreamUtils {
	public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

	private static XStream getInstance() {
		XStream xStream = new XStream(new DomDriver("utf-8", new XmlFriendlyNameCoder("_-", "_")));
		// 忽略未知节点
		xStream.ignoreUnknownElements();
		// 自定义Map转换
		xStream.registerConverter(new MapCustomConverter(new DefaultMapper(xStream.getClassLoaderReference())));
		// 20190819 添加
		xStream.registerConverter(new LongConverter() {
			@Override
			public Object fromString(String str) {
				if (StringUtils.isEmpty(str)) {
					return null;
				}
				return super.fromString(str);
			}
		});
		return xStream;
	}

	/**
	 * XML转对象
	 *
	 * @param clazz
	 *            对象类
	 * @param str
	 *            xml字符串
	 * @param <T>
	 *            T
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T parseFromXml(Class<T> clazz, String xml) {
		XStream xStream = getInstance();
		// 处理别名
		xStream.processAnnotations(clazz);
		// spring boot 热部署 会出现相同对象不能互转的异常,2019-01-23添加
		xStream.setClassLoader(clazz.getClassLoader());
		// 将XML字符串转为bean对象
		T t = (T) xStream.fromXML(xml);
		return t;
	}

	/**
	 * XML转对象
	 *
	 * @param clazz
	 *            对象类
	 * @param str
	 *            xml字符串
	 * @param <T>
	 *            T
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T parseFromXmlByAlias(Map<String, Class<?>> map, String xml) {
		XStream xStream = getInstance();
		for (Map.Entry<String, Class<?>> item : map.entrySet()) {
			// 处理别名
			// System.out.println("key:" + item.getKey() + "value:" + item.getValue());
			xStream.alias(item.getKey(), item.getValue());
		}
		// 将XML字符串转为bean对象
		T t = (T) xStream.fromXML(xml);
		return t;
	}

	/**
	 * 对象转xml
	 *
	 * @param obj
	 *            对象
	 * @return
	 */
	public static String toXml(Object obj) {
		XStream xStream = getInstance();
		xStream.processAnnotations(obj.getClass());
		return xStream.toXML(obj);
	}
}
