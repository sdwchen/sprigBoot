package com.sdw.service;


import com.sdw.entity.Form;
import com.sdw.mapper.FormMapper;
import com.sdw.page.PageResult;

import com.sdw.query.FormQueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class FormService {
    @Autowired
    private FormMapper formMapper;

    @Transactional
    public int insert(Form record) {
        // TODO Auto-generated method stub
        return formMapper.insert(record);
    }
    //前端App接口
    @Transactional
    public int add(Form record) {
        // TODO Auto-generated method stub
        return formMapper.add(record);
    }

    @Transactional
    public Form selectByPrimaryKey(Long id) {
        // TODO Auto-generated method stub
        return formMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public int updateByPrimaryKey(Form record) {
        // TODO Auto-generated method stub
        return formMapper.updateByPrimaryKey(record);
    }

    @Transactional
    public int deleteByPrimaryKey(long id) {
        // TODO Auto-generated method stub
        return formMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public PageResult queryByPage(FormQueryObject qo) {
        // TODO Auto-generated method stub
        //总数
        Long count = formMapper.queryEorPageCount(qo);
        System.out.println(count);
        if (count == 0) {
            return new PageResult(0, Collections.EMPTY_LIST);
        }
        List<Form> result = formMapper.queryForPage(qo);
        System.out.println("11111111111");
        return new PageResult(count.intValue(), result);
    }
    //查询预定订单
    @Transactional
    public List<Form> findOrder(Form form){
        return  formMapper.findOrder(form);
    }
    //查询预定订单
    @Transactional
    public List<Form> findAllOrder(Form form){
        return  formMapper.findAllOrder(form);
    }
    //查询所有订单
    @Transactional
    public List<Form> findAll(Form form){
        return  formMapper.findAll(form);
    }
}
