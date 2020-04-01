package com.sdw.mapper;


import com.sdw.entity.Form;
import com.sdw.query.FormQueryObject;

import java.util.List;

public interface FormMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Form record);
    int add(Form record);
    Form selectByPrimaryKey(Long id);

    List<Form> selectAll();

    int updateByPrimaryKey(Form record);

    //高级查询加分页
    Long queryEorPageCount(FormQueryObject qo);

    List<Form> queryForPage(FormQueryObject qo);
    List<Form> findOrder(Form form);
    List<Form> findAllOrder(Form form);
    List<Form> findAll(Form form);

}