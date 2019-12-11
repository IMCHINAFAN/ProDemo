package cn.study.springboot.mapper;

import cn.study.springboot.bean.Order;

public interface OrderMapper {

    /**
     * 添加订单列表
     */
    Integer addOrder(Order order);

    Integer deleteOrder(String orderId);
}
