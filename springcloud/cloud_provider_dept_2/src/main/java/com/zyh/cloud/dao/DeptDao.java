package com.zyh.cloud.dao;

import com.zyh.cloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper    //springBoot上面接口一定要加这个，或者主类执行方法加MapScan(配置加载的包名)
@Repository
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();

}
