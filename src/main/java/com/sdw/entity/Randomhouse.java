package com.sdw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class Randomhouse {
    private Long id;
    private String bname;//书名
    private String btype;//书类型
    private String ztime;//出借时间
    private Long state;//出借状态
    //对于时间来说在前端提交订单的时候把系统的时间传入到后台存到数据库中
    //对时间的处理bnb
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date starttime;//开始时间
    //对于时间来说在前端提交订单的时候把系统的时间传入到后台存到数据库中
    //对时间的处理bnb
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endtime;//结束时间
    private Long userid;//用户id
    private String bookdescribe;//描述
    private User user;//关联用户实体类


}