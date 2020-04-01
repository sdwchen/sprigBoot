package com.sdw.entity;

import lombok.Data;

@Data
public class Dormitory {
    private Long id;

    private String louceng;

    private String qisnhi;

    private Long userid;
    //如果表没有任何关联外键就不用写这个
    private User user;//这是以user中的id为主键Dormitory中的userid为外键定义实体类方便数据库的查询
}