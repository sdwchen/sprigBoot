package com.sdw.mapper;

import com.sdw.entity.Others;
import com.sdw.query.OthersQueryObject;

import java.util.List;

public interface OthersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Others record);

    Others selectByPrimaryKey(Long id);

    List<Others> selectAll();

    int updateByPrimaryKey(Others record);

    //高级查询加分页
    Long queryEorPageCount(OthersQueryObject qo);

    List<Others> queryForPage(OthersQueryObject qo);
}