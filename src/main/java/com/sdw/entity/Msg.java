package com.sdw.entity;

import lombok.Data;

@Data
public class Msg {
    private Long id;

    private String msg;

    private Long messageid;

    private Long userid;
    private Message message;
    private User user;
}