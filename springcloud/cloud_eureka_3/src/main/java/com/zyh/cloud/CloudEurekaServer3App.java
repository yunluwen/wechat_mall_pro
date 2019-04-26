package com.zyh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //EurekaSever服务器端启动类，接受其他微服务注册进来
public class CloudEurekaServer3App {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServer3App.class,args);
    }
}
