/*
 * 文件名：UserController.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： UserController.java
 * 修改人：lizhi 1708029
 * 修改时间：2019年8月6日
 * 修改内容：新增
 */
package com.itmuch.cloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.dao.UserDao;
import com.itmuch.cloud.entity.User;
import com.itmuch.utils.json.JsonUtil;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

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
	private UserDao userDao;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/simple")
	public User findById(@RequestBody User user) {
		return this.userDao.getOne(user.getId());
	}
	
	@RequestMapping("/eureka-instance")
	public String serviceUrl(@RequestBody String string) {
		User user = JsonUtil.toObject(string, User.class);
		System.err.println("获取到的值string:"+user.getId());
		InstanceInfo instanceInfo = this.eurekaClient.getNextServerFromEureka("microservice-provider-user", false);
		return instanceInfo.getHomePageUrl();
	}
	
	@GetMapping("/instance-info")
	public Map<String, Object> showInServiceInstance() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> listServiceNames = this.discoveryClient.getServices();
		for (String serviceName : listServiceNames) {
			List<ServiceInstance> serviceInstances = this.discoveryClient.getInstances(serviceName);
			map.put(serviceName, serviceInstances);
		}
		
		return map;
	}
}
