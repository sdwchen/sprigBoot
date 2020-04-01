package com.sdw.mapper;

import com.sdw.entity.Information;
import com.sdw.query.InformationQueryObject;

import java.util.List;

public interface InformationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Information record);

    Information selectByPrimaryKey(Long id);

    List<Information> selectAll();

    int updateByPrimaryKey(Information record);
    //高级查询加分页
    Long queryEorPageCount(InformationQueryObject qo);

    List<Information> queryForPage(InformationQueryObject qo);
}