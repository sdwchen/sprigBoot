package com.sdw.entity;

import lombok.Data;

@Data
public class Book {
    private Long id;

    private String bookname;

    private String booktype;

    private Long orderid;
    private Dingdan dingdan;//订单实体类


}