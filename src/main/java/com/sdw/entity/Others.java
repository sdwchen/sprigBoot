package com.sdw.entity;

import lombok.Data;

@Data
public class Others {
    private Long id;

    private String othersname;

    private String otherstype;

    private Long orderid;
    private Dingdan dingdan;//订单实体类

}