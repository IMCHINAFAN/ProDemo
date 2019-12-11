package cn.study.springboot.service.impl;

import cn.study.springboot.bean.Goods;
import cn.study.springboot.mapper.GoodsMapper;
import cn.study.springboot.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: GoodsService
 * @author: 10724
 * @date: Created in 2019/11/25
 * @Description:
 */
@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Integer updateStock(Integer goodsId) {
        Integer num = goodsMapper.updateStock(goodsId);
        return num;
    }

    @Override
    public Goods getGoodsById(Integer goodsId) {
        if(null != goodsId){
            Goods goods = goodsMapper.getGoodsById(goodsId);
            return goods;
        }
        return null;
    }
}
