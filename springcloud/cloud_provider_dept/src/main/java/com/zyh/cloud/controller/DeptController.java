package com.zyh.cloud.controller;

import com.zyh.cloud.entities.Dept;
import com.zyh.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   //相当于Controller  + ResponseBody
public class DeptController {

    @Autowired
    private DeptService deptService;

//    @Autowired
//    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept){  //传过来数据
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
        return deptService.get(id);
    }

    //@GetMapping("/dept/list")
    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> getAll(){
        return deptService.list();
    }


    /**
     * 测试注册到Eureka上面的服务发现
     * 打印所有微服务的信息
     */
//    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
//    public Object discovery()
//    {
//        List<String> list = client.getServices();
//        System.out.println("**********" + list);
//
//        List<ServiceInstance> srvList = client.getInstances("CLOUD-DEPT");
//        for (ServiceInstance element : srvList) {
//            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
//                    + element.getUri());
//        }
//        return this.client;
//    }

}
