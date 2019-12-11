package cn.study.springboot.service;

import cn.study.springboot.bean.Order;

public interface OrderService {
    /**
     * 添加订单列表
     */
    Integer addOrder(Order order);

    Integer deleteOrder(String orderId);

}
