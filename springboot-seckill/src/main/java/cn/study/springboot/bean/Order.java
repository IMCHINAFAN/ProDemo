package cn.study.springboot.bean;

import java.io.Serializable;

/**
 * @ClassName: Order
 * @author: 10724
 * @date: Created in 2019/11/20
 * @Description:
 */
public class Order implements Serializable {
    private static final long serialVersionUID = -5639150056151994172L;
    private String orderId;
    private Integer goodsId;
    private Integer userId;

    public Order() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
