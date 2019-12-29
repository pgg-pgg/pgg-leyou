package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {

    PRICE_CANNOT_BE_NULL(400,""),
    BRANDS_NOT_FIND(404,"品牌不存在"),
    CATEGORY_LIST_IS_EMPTY(404,"商品分类未查到")
    ;
    private int code;
    private String message;
}
