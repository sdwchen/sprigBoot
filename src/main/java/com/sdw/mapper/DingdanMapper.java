package com.sdw.mapper;

import com.sdw.entity.Dingdan;
import com.sdw.query.DingdanQueryObject;

import java.util.List;

public interface DingdanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Dingdan record);

    Dingdan selectByPrimaryKey(Long id);

    List<Dingdan> selectAll();

    int updateByPrimaryKey(Dingdan record);

    //高级查询加分页
    Long queryEorPageCount(DingdanQueryObject qo);

    List<Dingdan> queryForPage(DingdanQueryObject qo);
}