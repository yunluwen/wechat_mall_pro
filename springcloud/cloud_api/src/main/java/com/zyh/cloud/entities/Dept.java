package com.zyh.cloud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 使用lombok,注意在idea里面安装lombok插件
 */
@SuppressWarnings("serial")
@NoArgsConstructor         //无参构造函数
@AllArgsConstructor        //全参构造函数
@Data                      //get/set方法
@Accessors(chain = true)   //链式风格访问类的属性
public class Dept implements Serializable {   //必须序列化

    private Long deptNo;
    private String dName;
    private String dbSource;

}
