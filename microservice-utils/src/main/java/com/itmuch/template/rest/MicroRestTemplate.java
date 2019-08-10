/*
 * 文件名：MicroRestTemplate.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： MicroRestTemplate.java
 * 修改人：lizhi 1708029
 * 修改时间：2019年8月10日
 * 修改内容：新增
 */
package com.itmuch.template.rest;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Title:  MicroRestTemplate.java
 * @Package: com.itmuch.cloud.template.rest.MicroRestTemplate.java
 * @Description: 
 * @Company: ylink
 * @author  lizhi 
 * @date  2019年8月10日 下午1:38:42
 */
@Service
public class MicroRestTemplate {

	@Resource
	private RestTemplate restTemplate;
	
	/**
	 * 使用服务名和访问路径进行访问
	 * @param serviceName
	 * @param path
	 * @param body
	 * @return
	 */
	public String postString(String serviceName, String path, String body) {
		return this.restTemplate.postForObject(formatUrl(serviceName, path), body, String.class, new Object[0]);
	}
	
	/**
	 * 使用javabean传输
	 * @param serviceName
	 * @param path
	 * @param body
	 * @return
	 */
	public <T> T postForObject(String serviceName, String path, Object request, Class<T> responseType) {
		return this.restTemplate.postForObject(formatUrl(serviceName, path), request, responseType);
	}
	
	/**
	 * 格式化url访问路径
	 * @param serviceName
	 * @param path
	 * @return
	 */
	public String formatUrl(String serviceName, String path) {
		if (path == null) {
			path = "";
		}

		String str = serviceName + "/" + path;
		str = str.replace("//", "/");
		return "http://" + str;
	}
}
