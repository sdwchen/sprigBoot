package com.sdw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Dingdan {
    private Long id;

    private Long bookid;//关联书本

    private Long userid;//关联用户
    //0表示提交失败 1表示正在提交等待管理员确定2表示管理员确定次订单
    //3表示订单已处理
    //在前台进行判断写的if什么数字对应什么状态渲染在页面上
    private Integer state;//表示订单的状态

    private Long clothesid;//关联衣服

    private Long othersid;//关联其它

    private Date time;//订单发起时间
    private User user;//用户实体
    private Book book;//书本实体
    private Clothes clothes;//衣服实体
    private Others others;//其他实体
}