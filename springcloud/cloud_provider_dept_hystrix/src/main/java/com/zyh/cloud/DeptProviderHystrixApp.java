package com.zyh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 该微服务的主启动类
 * 约定 > 配置 > 编码
 */
//@MapperScan("com.zyh.cloud.dao")
@SpringBootApplication
@EnableEurekaClient      //本服务启动后会自动注册到Eureka服务中
@EnableDiscoveryClient   //提供服务发现，对外可以暴露
@EnableCircuitBreaker    //对Hystrix服务熔断的支持
public class DeptProviderHystrixApp {

    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrixApp.class,args);
    }
}
