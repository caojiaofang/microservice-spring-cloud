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
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itmuch.cloud.entity.User;

/**
 * @Title:  UserFeignClient.java
 * @Package: com.itmuch.cloud.config.UserFeignClient.java
 * @Description: 
 * @Company: ylink
 * @author  lizhi 
 * @date  2019年8月10日 下午9:06:41
 */

//@FeignClient(name = "microservice-provider-user", configuration = FeignClientsConfiguration.class)
@FeignClient("microservice-provider-user")
public interface UserFeignClient {

	@RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") Integer id);
	
	@RequestMapping(value = "/simple", method = RequestMethod.POST)
	public User findById(@RequestBody User user);
}
