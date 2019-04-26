package com.zyh.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 注解配置类
 */
@Configuration
public class ConfigBean { //boot -->spring   applicationContext.xml --- @Configuration配置   ConfigBean = applicationContext.xml

    //Ribbon负载均衡（客户端的负载均衡）
    @LoadBalanced  //如果是传统服务调用 不需要负载均衡 微服务调用必须加
    @Bean
    public RestTemplate getRestTemplate() {
        //RestTemplate是用于调用RestApi接口的模版
        //RestTemplate提供了多种便捷访问远程Http服务的方法，是一种简单便捷的访问restful
        //服务模板类，是spring提供的用于访问Rest服务的客户端模板工具集
        return new RestTemplate();
    }

    //配置Ribbon的负载均衡策略
    //默认是采用的轮询策略
    //一共有七种规则
    @Bean
    public IRule myRule(){
        //达到的目的，用我们重新选择的随机算法提到默认的轮询。
        return new RandomRule();
    }

}

//@Bean
//public UserServcie getUserServcie()
//{
//	return new UserServcieImpl();
//}
// applicationContext.xml == ConfigBean(@Configuration)
//<bean id="userServcie" class="com.atguigu.tmall.UserServiceImpl">