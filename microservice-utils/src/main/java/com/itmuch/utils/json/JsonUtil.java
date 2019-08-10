/*
 * 文件名：JsonUtil.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： JsonUtil.java
 * 修改人：lizhi 1708029
 * 修改时间：2019年8月10日
 * 修改内容：新增
 */
package com.itmuch.utils.json;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Title:  JsonUtil.java
 * @Package: com.itmuch.cloud.utils.json.JsonUtil.java
 * @Description: 
 * @Company: ylink
 * @author  lizhi 
 * @date  2019年8月10日 下午2:21:59
 */
@Component
public class JsonUtil {

	private static ObjectMapper objectMapper;

	@Resource
	public void setObjectMapper(ObjectMapper objectMapper) {
		JsonUtil.objectMapper = objectMapper;
		objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
	}

	/**
	 * Object->JsonString
	 */
	public static String toJson(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * JsonString->Object
	 */
	public static <T> T toObject(String jsonStr, Class<T> clazz) {
		try {
			return objectMapper.readValue(jsonStr, clazz);
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * JsonString->List
	 */
	public static <T> List<T> toList(String jsonStr) {
		try {
			return objectMapper.readValue(jsonStr, new TypeReference<List<T>>() {
			});
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * JsonString->Map
	 */
	public static <T> Map<String, T> toMap(String jsonStr) {
		try {
			return objectMapper.readValue(jsonStr, new TypeReference<Map<String, T>>() {
			});
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 获取Json串里的指定值
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getValueInJson(String jsonStr, String key) {
		Map<String, Object> map = toMap(jsonStr);
		if (map == null) {
			return null;
		}
		return (T) map.get(key);
	}

}
