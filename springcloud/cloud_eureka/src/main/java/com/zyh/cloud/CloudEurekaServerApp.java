package com.zyh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EurekaServer 服务端注册中心
 */
@SpringBootApplication
@EnableEurekaServer  //EurekaSever服务器端启动类，接受其他微服务注册进来
public class CloudEurekaServerApp {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServerApp.class,args);
    }
}
