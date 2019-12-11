package cn.study.springboot.web;

import cn.study.springboot.bean.Goods;
import cn.study.springboot.bean.Order;
import cn.study.springboot.service.GoodsService;
import cn.study.springboot.service.OrderService;
import cn.study.springboot.util.OrderCodeFactory;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: OrderMapper
 * @author: 10724
 * @date: Created in 2019/11/26
 * @Description:
 */
@RestController
public class OnlionController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/seckill/{goodsId}")
    public JSONObject seckill(@PathVariable("goodsId") Integer goodsId) {
        JSONObject json = new JSONObject();

        Goods goods = goodsService.getGoodsById(goodsId);
        if (goods.getGoodsStock() <= 0) {
            json.put("msg","商品已售完");
            return json;
        }

        Integer num = goodsService.updateStock(goodsId);
        if(num < 0){
            throw new RuntimeException("商品已经售光");
        }

        Order order = new Order();
        order.setOrderId(OrderCodeFactory.getOrderCode());
        order.setUserId(1);
        order.setGoodsId(goodsId);
        Integer resultNum = orderService.addOrder(order);
        return json;
    }
}
