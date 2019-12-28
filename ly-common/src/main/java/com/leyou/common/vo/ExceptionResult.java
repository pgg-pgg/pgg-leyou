package com.leyou.common.vo;

import com.leyou.common.enums.ExceptionEnum;
import lombok.Data;

@Data
public class ExceptionResult {

    private String message;
    private int status;
    private Long timeStamp;

    public ExceptionResult(ExceptionEnum em){
        this.message = em.getMessage();
        this.status = em.getCode();
        this.timeStamp = System.currentTimeMillis();
    }
}
