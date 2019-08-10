/*
 * 文件名：EurekaApplication.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： EurekaApplication.java
 * 修改人：lizhi 1708029
 * 修改时间：2019年8月8日
 * 修改内容：新增
 */
package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Title:  EurekaApplication.java
 * @Package: com.itmuch.cloud.EurekaApplication.java
 * @Description: 
 * @Company: ylink
 * @author  lizhi 
 * @date  2019年8月8日 上午9:26:31
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

	public static void main(String[] args) {

		SpringApplication.run(EurekaApplication.class, args);
	}

}
