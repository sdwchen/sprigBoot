package com.sdw.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Menu {
    private Long id;

    private String text;

    private String attributes;

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", attributes='" + attributes + '\'' +
                '}';
    }
}