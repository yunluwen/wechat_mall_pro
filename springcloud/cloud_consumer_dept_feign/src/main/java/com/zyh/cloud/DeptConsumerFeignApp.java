package com.zyh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient      //本服务启动后会自动注册到Eureka服务中
@EnableFeignClients(basePackages = {"com.zyh.cloud"})
@ComponentScan("com.zyh.cloud")   //设置要扫描的包
public class DeptConsumerFeignApp {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeignApp.class,args);
    }
}
