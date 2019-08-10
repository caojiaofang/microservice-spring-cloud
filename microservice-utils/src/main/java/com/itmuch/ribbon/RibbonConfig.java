/*
 * 文件名：RibbonConfig.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： RibbonConfig.java
 * 修改人：lizhi 1708029
 * 修改时间：2019年8月10日
 * 修改内容：新增
 */
package com.itmuch.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCloudPlatform;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
/**
 * @Title:  RibbonConfig.java
 * @Package: com.itmuch.ribbon.RibbonConfig.java
 * @Description: ribbon默认是轮巡，所以此处自定义随机负载均衡
 * @Company: ylink
 * @author  lizhi 
 * @date  2019年8月10日 下午4:10:46
 */
@Configuration
public class RibbonConfig {

	@Autowired
	private IClientConfig config;
	
	@Bean
    @ConditionalOnMissingBean
    public IRule ribbonRule(IClientConfig config) {
        System.out.println("-------ribbon自定义随机------");
        return new RandomRule();
    }

}
