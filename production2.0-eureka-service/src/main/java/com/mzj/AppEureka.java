package com.mzj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AppEureka {

	public static void main(String[] agrs) {

		SpringApplication.run(AppEureka.class, agrs);
	}
}
