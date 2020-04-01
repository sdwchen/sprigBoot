package com.sdw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Form {
    private Long id;
    private String bookname;//书名
    private String booktype;//书的类型
    private String clothesname;//衣服的名字
    private String clothestype;//衣服的类型
    private String othersname;//其它
    private String otherstype;//其它的种类
    private Long userid;//用户关联的id
    private long dormitoryid;//地址id
    private Integer state;//订单的状态，1表示提交中，0表示提交失败，2表示提交成功
    //对时间的处理
    //对于时间来说在前端提交订单的时候把系统的时间传入到后台存到数据库中
    //对时间的处理bnb
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date starttime;//订单发起时间
    //对时间的处理
    //对于时间来说在前端接受订单的时候把系统的时间传入到后台存到数据库中
    //对时间的处理bnb
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endtime;//订单结束时间
    private User user;//用户实体类
    private Dormitory dormitory;//地址实体类

}