package com.sdw.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class User {
    private Integer userid;

    private String username;

    private String password;

    private String realname;

    private String tel;


}
