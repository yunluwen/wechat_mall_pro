package com.zyh.mall.service;

import com.zyh.mall.dataobject.ProductCategory;

import java.util.List;

/**
 * 商品类目操作接口
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
