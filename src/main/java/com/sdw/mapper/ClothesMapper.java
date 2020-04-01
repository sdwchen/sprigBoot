package com.sdw.mapper;

import com.sdw.entity.Clothes;
import com.sdw.query.ClothesQueryObject;

import java.util.List;

public interface ClothesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Clothes record);

    Clothes selectByPrimaryKey(Long id);

    List<Clothes> selectAll();

    int updateByPrimaryKey(Clothes record);

    //高级查询加分页
    Long queryEorPageCount(ClothesQueryObject qo);

    List<Clothes> queryForPage(ClothesQueryObject qo);
}