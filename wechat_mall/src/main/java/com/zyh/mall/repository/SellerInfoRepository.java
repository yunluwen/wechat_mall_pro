package com.zyh.mall.repository;

import com.zyh.mall.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 卖家信息
 */
public interface SellerInfoRepository
        extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
}
