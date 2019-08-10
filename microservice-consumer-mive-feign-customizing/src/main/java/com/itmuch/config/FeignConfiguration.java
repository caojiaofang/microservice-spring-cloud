/*
 * 文件名：FeignConfiguration.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： FeignConfiguration.java
 * 修改人：lizhi 1708029
 * 修改时间：2019年8月10日
 * 修改内容：新增
 */
package com.itmuch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

/**
 * @Title:  FeignConfiguration.java
 * @Package: com.itmuch.config.FeignConfiguration.java
 * @Description: 
 * @Company: ylink
 * @author  lizhi 
 * @date  2019年8月10日 下午9:50:00
 */

@Configuration
public class FeignConfiguration {

	@Bean
	public Contract feignContract() {
		return new feign.Contract.Default();
	}
	
	@Bean
	feign.Logger.Level feignLoggerLevel() {
		return feign.Logger.Level.FULL;
	}
}
