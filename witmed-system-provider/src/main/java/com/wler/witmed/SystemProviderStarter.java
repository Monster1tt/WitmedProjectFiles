package com.wler.witmed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>智慧医疗-系统功能- Provider 启动类</b>
 *
 * @author Monster
 * @version 1.0.0
 */
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.wler.witmed.dao")
public class SystemProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(SystemProviderStarter.class, args);
	}
}
