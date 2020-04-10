package com.sdw.entity;

import lombok.Data;

@Data
public class Appointment {
    private Long id;

    private Long randomhouseid;//书社订单id
    private  Randomhouse randomhouse;
    private Long userid;//用户id
    private  User user;

}