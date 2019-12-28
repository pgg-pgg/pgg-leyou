package com.leyou.goods.service;

import com.leyou.goods.pojo.Goods;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GoodsService {

    public Goods saveGoods(Goods goods){
        int id = new Random().nextInt(100);
        goods.setId(id);
        return goods;
    }
}
