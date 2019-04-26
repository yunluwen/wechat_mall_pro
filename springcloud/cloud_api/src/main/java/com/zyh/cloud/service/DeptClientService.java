package com.zyh.cloud.service;

import com.zyh.cloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//针对具体的某一个微服务
//加上服务熔断属性 : fallbackFactory
@FeignClient(value = "CLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id);

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(Dept dept);

    /**
     * 测试一下这个是否可以访问
     * @return
     */
    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> getAll();

}
