package com.saman.tutorial.springactivemq.model;

import java.util.stream.Stream;

public enum ProductStatus {
 
    CREATED(100),
    PENDING(400),
    CONFIRMED(200),
    FAILED(300),
    UNKNOWN(500),
    ;

    private final Integer code;
      
    ProductStatus(final Integer code){
        this.code = code;
    }

    public static ProductStatus getByCode(final int code){
        return Stream.of(ProductStatus.values())
                .filter(item -> item.code == code)
                .findFirst()
                .orElse(UNKNOWN);
    }
      
    @Override
    public String toString(){
        return this.name();
    }
  
}