package com.sdw.entity;

import lombok.Data;

@Data
public class Clothes {
    private Long id;

    private String clothesname;

    private String clothestype;

    private Long orderid;
    private Dingdan dingdan;//订单实体类


}