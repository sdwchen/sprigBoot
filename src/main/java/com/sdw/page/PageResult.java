package com.sdw.page;

import lombok.Data;

import java.util.List;

@Data
//分页结果集
public class PageResult {
    private Integer total; // 总条数
    private List rows; // 结果集


    public Integer getTotal() {
        return total;
    }


    public void setTotal(Integer total) {
        this.total = total;
    }


    public List getRows() {
        return rows;
    }


    public void setRows(List rows) {
        this.rows = rows;
    }


    public PageResult(Integer total, List rows) {
        this.total = total;
        this.rows = rows;
    }


}
