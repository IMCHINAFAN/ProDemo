package cn.study.springboot.service.impl;

import cn.study.springboot.bean.Order;
import cn.study.springboot.mapper.OrderMapper;
import cn.study.springboot.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: OrderServiceImpl
 * @author: 10724
 * @date: Created in 2019/11/25
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Integer addOrder(Order order) {
        if(order != null){
            try{
                Integer num = orderMapper.addOrder(order);
                return num;
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("orderService exception"+e.getMessage());
            }
        }
        return null;
    }

    @Override
    public Integer deleteOrder(String orderId) {
        if(null != orderId && !"".equals(orderId)){
            try{
                Integer num = orderMapper.deleteOrder(orderId);
                return num;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
