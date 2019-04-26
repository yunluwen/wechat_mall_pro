package com.zyh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 只能监控整合了Hystrix的微服务
 * 其他的监控不到
 */
@SpringBootApplication
@EnableHystrixDashboard   //启用服务监控看板
public class DeptConsumerHystrixDashBoardApp {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerHystrixDashBoardApp.class,args);
    }
}
