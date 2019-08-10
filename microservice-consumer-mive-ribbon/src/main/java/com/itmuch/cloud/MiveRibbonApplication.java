package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.itmuch.ribbon.RibbonConfig;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "microservice-provider-user", configuration = RibbonConfig.class)
public class MiveRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiveRibbonApplication.class, args);
	}

}
