package cn.study.springboot.bean;

import java.io.Serializable;

/**
 * @ClassName: Goods
 * @author: 10724
 * @date: Created in 2019/11/20
 * @Description:
 */
public class Goods implements Serializable {
    private static final long serialVersionUID = 8237068799245403635L;
    private Integer goodsId;
    private String goodsName;
    private Long goodsStock;

    public Goods() {
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Long goodsStock) {
        this.goodsStock = goodsStock;
    }
}
