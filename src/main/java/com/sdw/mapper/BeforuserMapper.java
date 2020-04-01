package com.sdw.mapper;

import com.sdw.entity.Beforuser;
import com.sdw.query.BeforuserQueryObject;

import java.util.List;

public interface BeforuserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Beforuser record);

    Beforuser selectByPrimaryKey(Long id);

    List<Beforuser> selectAll();

    int updateByPrimaryKey(Beforuser record);

    //高级查询加分页
    Long queryEorPageCount(BeforuserQueryObject qo);

    List<Beforuser> queryForPage(BeforuserQueryObject qo);
}