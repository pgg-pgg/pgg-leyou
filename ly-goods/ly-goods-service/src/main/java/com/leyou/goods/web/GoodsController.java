package com.leyou.goods.web;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.goods.pojo.Goods;
import com.leyou.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    @PostMapping
    public ResponseEntity<Goods> saveGoods(Goods goods){

        //校验价格
        if (goods.getPrice() == null){
            throw new LyException(ExceptionEnum.PRICE_CANNOT_BE_NULL);
        }
        goods = goodsService.saveGoods(goods);
        return ResponseEntity.status(HttpStatus.CREATED).body(goods);
    }
}
