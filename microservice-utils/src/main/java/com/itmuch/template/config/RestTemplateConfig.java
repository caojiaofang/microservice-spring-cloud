/*
 * 文件名：RestTemplateConfig.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： RestTemplateConfig.java
 * 修改人：lizhi 1708029
 * 修改时间：2019年8月6日
 * 修改内容：新增
 */
package com.itmuch.template.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Title:  RestTemplateConfig.java
 * @Package: com.itmuch.cloud.config.RestTemplateConfig.java
 * @Description: 
 * @Company: ylink
 * @author  lizhi 
 * @date  2019年8月6日 下午4:37:13
 */
@Configuration
public class RestTemplateConfig {

	@Bean
	@LoadBalanced   //使用了Ribbon的负载均衡
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
