/*
 * 文件名：UserFeignClient.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： UserFeignClient.java
 * 修改人：lizhi 1708029
 * 修改时间：2019年8月10日
 * 修改内容：新增
 */
package com.itmuch.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.itmuch.cloud.entity.User;
import com.itmuch.config.FeignConfiguration;

import feign.Param;
import feign.RequestLine;

/**
 * @Title:  UserFeignClient.java
 * @Package: com.itmuch.cloud.config.UserFeignClient.java
 * @Description: 
 * @Company: ylink
 * @author  lizhi 
 * @date  2019年8月10日 下午9:06:41
 */

@FeignClient(name = "microservice-provider-user", configuration = FeignConfiguration.class)
public interface UserFeignClient {

	@RequestLine("GET /simple/{id}")
	public User findById(@Param("id") Integer id);
	
}
