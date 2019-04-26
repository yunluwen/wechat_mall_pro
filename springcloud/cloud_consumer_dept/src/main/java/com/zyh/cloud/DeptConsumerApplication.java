package com.zyh.cloud;

import com.zyh.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient      //本服务启动后会自动注册到Eureka服务中
//在启动该微服务的时候就能去加载我们的自定义的Ribbon配置类，从而使配置生效。
//注意MySelfRule这个自定义的规则类，不能放在当前springboot主类所在项目的包以及子包下
@RibbonClient(name = "CLOUD-DEPT",configuration = MySelfRule.class)   //自定义Ribbon策略
public class DeptConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerApplication.class,args);
    }
}
