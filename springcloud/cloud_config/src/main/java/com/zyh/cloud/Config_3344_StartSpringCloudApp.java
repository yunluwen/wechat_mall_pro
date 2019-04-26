package com.zyh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * SpringCloud 配置
 * 结合github上面的远程配置，动态获取指定的配置信息
 *
 * 注意访问配置文件的方式
 */
@SpringBootApplication
@EnableConfigServer       //配置中心Server
public class Config_3344_StartSpringCloudApp {

    public static void main(String[] args) {
        SpringApplication.run(Config_3344_StartSpringCloudApp.class, args);
    }

}