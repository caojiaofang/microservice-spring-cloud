/*
 * 文件名：EurekaFeignClient.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： EurekaFeignClient.java
 * 修改人：lizhi 1708029
 * 修改时间：2019年8月10日
 * 修改内容：新增
 */
package com.itmuch.cloud.feign;
/**
 * @Title:  EurekaFeignClient.java
 * @Package: com.itmuch.cloud.feign.EurekaFeignClient.java
 * @Description: 
 * @Company: ylink
 * @author  lizhi 
 * @date  2019年8月10日 下午10:04:55
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "eureka-feign", url = "http://127.0.0.1:8761/")
public interface EurekaFeignClient {

	@RequestMapping(value = "/eureka/apps/{serviceName}", method = RequestMethod.GET)
	public String findEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
