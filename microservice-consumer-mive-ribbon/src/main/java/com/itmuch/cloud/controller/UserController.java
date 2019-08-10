/*
 * 文件名：UserController.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： UserController.java
 * 修改人：lizhi 1708029
 * 修改时间：2019年8月6日
 * 修改内容：新增
 */
package com.itmuch.cloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.entity.User;
import com.itmuch.template.rest.MicroRestTemplate;
import com.itmuch.utils.json.JsonUtil;

/**
 * @Title:  UserController.java
 * @Package: com.itmuch.cloud.controller.UserController.java
 * @Description: 
 * @Company: ylink
 * @author  lizhi 
 * @date  2019年8月6日 下午3:27:45
 */
@RestController
public class UserController {

	@Resource
	private MicroRestTemplate microRestTemplate;
	
	@GetMapping("/movie/{id}")
	public String findById(@PathVariable Integer id) {
		User user = new User();
		user.setId(id);
		user = this.microRestTemplate.postForObject("MICROSERVICE-PROVIDER-USER", "simple", user, User.class);
		System.err.println("获取到用户名:"+user.getName());
		return this.microRestTemplate.postString("MICROSERVICE-PROVIDER-USER","eureka-instance", JsonUtil.toJson(user));
	}
}
