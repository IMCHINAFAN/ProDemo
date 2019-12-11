package cn.study.springboot.service;

import cn.study.springboot.bean.Goods;

public interface GoodsService {

    Integer updateStock(Integer goodsId);

    Goods getGoodsById(Integer goodsId);
}
