package com.sdw.mapper;

import com.sdw.entity.Dormitory;
import com.sdw.query.DormitoryQueryObject;

import java.util.List;

public interface DormitoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Dormitory record);

    Dormitory selectByPrimaryKey(Long id);

    List<Dormitory> selectAll();

    int updateByPrimaryKey(Dormitory record);

    //高级查询加分页
    Long queryEorPageCount(DormitoryQueryObject qo);
    List<Dormitory> queryForPage(DormitoryQueryObject qo);
    //修改用户名和密码
    int updateLQ(Dormitory record);
    //    前端App添加
    int add(Dormitory record);


}