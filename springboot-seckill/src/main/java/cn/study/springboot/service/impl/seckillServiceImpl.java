package cn.study.springboot.service.impl;

import cn.study.springboot.bean.Goods;
import cn.study.springboot.bean.Order;
import cn.study.springboot.mapper.GoodsMapper;
import cn.study.springboot.mapper.OrderMapper;
import cn.study.springboot.service.seckillService;
import cn.study.springboot.util.OrderCodeFactory;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: seckillServiceImpl
 * @author: 10724
 * @date: Created in 2019/11/26
 * @Description:
 */
@Service
public class seckillServiceImpl implements seckillService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private OrderMapper orderMapper;


    /**
     * 1.判断商品库存是否足够
     * 2.若库存足够就减少商品库存并添加订单
     * 3.若删除订单时，将商品库存还原
     */
    @Override
    @Transactional
    public JSONObject seckill(Integer goodsId) {
        JSONObject json = new JSONObject();
        try {
            Goods goods = goodsMapper.getGoodsById(goodsId);
            if (null == goods) {
                throw new RuntimeException();
            }

            Integer resultNum = goodsMapper.updateStock(goodsId);
            if (resultNum <= 0) {
                throw new RuntimeException();
            }

            Order order = new Order();
            order.setUserId(1);
            order.setGoodsId(goodsId);
            order.setOrderId(OrderCodeFactory.getOrderCode());

            Integer num = orderMapper.addOrder(order);
            if (num < 0) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
