package com.sdw.entity;

import lombok.Data;
/*
*
* 资讯实体类
* */
@Data
public class Information {
    private Long id;

    private String informationtitle;//资讯标题

    private String information;//资讯内容

    private String imgurl;//资讯图片
}