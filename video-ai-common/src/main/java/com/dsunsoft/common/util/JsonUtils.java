package com.dsunsoft.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dsunsoft.common.constant.CommonConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;

/**
 * JacksonUtils
 * 
 * @author ygm
 *
 */
public class JsonUtils {
	private static final ObjectMapper objectMapper = new ObjectMapper();
	private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

	static {
		// 日期转化
		objectMapper.setTimeZone(TimeZone.getTimeZone(CommonConstants.TIME_ZONE));
		objectMapper.setDateFormat(new SimpleDateFormat(CommonConstants.DATE_FORMAT));
		// 设置空如何序列化
		objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
		// 忽略json中不存在的属性
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// 允许出现特殊字符和转义符
		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		// 允许出现单引号
		objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
	}

	/**
	 * 对象转为json字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static <T> String toJson(T obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			logger.error("JsonUtils error:" + e.getMessage());
			return null;
		}

	}

	/**
	 * json字符串转为对象
	 * 
	 * @param json
	 * @param type
	 * @return
	 */
	public static <T> T parseObject(String json, Class<T> type) {
		try {
			return objectMapper.readValue(json, type);
		} catch (Exception e) {
			logger.error("JsonUtils error:" + e.getMessage());
			return null;
		}
	}

	/**
	 * json字符串转为Map
	 * 
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseMap(String json) {
		try {
			return objectMapper.readValue(json, Map.class);
		} catch (Exception e) {
			logger.error("JsonUtils error:" + e.getMessage());
			return null;
		}
	}
}
