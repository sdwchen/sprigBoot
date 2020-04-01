package com.sdw.query;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryObject {
    private Integer page; // 当前页
    private Integer rows; // 每页最多显示多少条

    // 分页时每页的起始行
    private Integer getStart() {
        return (this.page - 1) * this.rows;
    }
}
