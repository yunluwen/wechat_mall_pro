package com.zyh.cloud.service;

import java.util.List;

import com.zyh.cloud.entities.Dept;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

/**
 * 微服务
 * 服务熔断，hyatrix熔断处理方法
 */
@Component   // 不要忘记添加，不要忘记添加
public class DeptClientServiceFallbackFactory
        implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable)
    {
        return new DeptClientService() {

            @Override
            public Dept get(long id) {
                return new Dept().setDeptNo(id)
                        .setDName("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
                        .setDbSource("no this database in MySQL");
            }

            @Override
            public List<Dept> getAll() {
                return null;

            }

            @Override
            public boolean add(Dept dept)
            {
                return false;
            }
        };
    }
}
