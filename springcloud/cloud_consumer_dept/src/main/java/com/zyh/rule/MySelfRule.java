package com.zyh.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        //达到的目的，用我们重新选择的随机算法提到默认的轮询。
        //return new RandomRule();

        //return new RoundRobinRule();

        //自定义的客户端负载均衡策略，采用轮询，每台server访问5次
        return new RandomRule_ZYH();
    }

}
