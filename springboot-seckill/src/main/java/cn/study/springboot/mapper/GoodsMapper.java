package cn.study.springboot.mapper;

import cn.study.springboot.bean.Goods;

public interface GoodsMapper {

    /**
     * 更新库存
     */
    Integer updateStock(Integer goodsId);

    Goods getGoodsById(Integer goodsId);
}
