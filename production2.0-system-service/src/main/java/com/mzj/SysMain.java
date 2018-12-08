package com.mzj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@MapperScan("com.mzj.mapper")
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SysMain {
	
	public static void main(String[] args) {
		SpringApplication.run(SysMain.class, args);
	}
}
