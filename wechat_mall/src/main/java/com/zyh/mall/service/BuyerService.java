package com.zyh.mall.service;


import com.zyh.mall.dto.OrderDTO;

/**
 * 买家端
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
