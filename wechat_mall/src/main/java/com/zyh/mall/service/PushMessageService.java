package com.zyh.mall.service;

import com.zyh.mall.dto.OrderDTO;

/**
 * webSocket消息
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
