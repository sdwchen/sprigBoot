package com.sdw.mapper;

import com.sdw.entity.Randomhouse;
import java.util.List;

public interface RandomhouseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Randomhouse record);

    Randomhouse selectByPrimaryKey(Long id);
    //查询所有
    List<Randomhouse> selectAll();

    int updateByPrimaryKey(Randomhouse record);
    //修改状态
    int updateState(Randomhouse record);
}