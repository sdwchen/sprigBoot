package com.sdw.service;


import com.sdw.entity.Book;
import com.sdw.entity.Dingdan;
import com.sdw.mapper.BookMapper;
import com.sdw.mapper.DingdanMapper;
import com.sdw.page.PageResult;
import com.sdw.query.BookQueryObject;
import com.sdw.query.DingdanQueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class DingdanService {
    @Autowired
    private DingdanMapper dingdanMapper;

    @Transactional
    public int insert(Dingdan record) {
        // TODO Auto-generated method stub
        return dingdanMapper.insert(record);
    }

    @Transactional
    public Dingdan selectByPrimaryKey(Long id) {
        // TODO Auto-generated method stub
        return dingdanMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public int updateByPrimaryKey(Dingdan record) {
        // TODO Auto-generated method stub
        return dingdanMapper.updateByPrimaryKey(record);
    }

    @Transactional
    public int deleteByPrimaryKey(long id) {
        // TODO Auto-generated method stub
        return dingdanMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public List<Dingdan> selectAll() {
        return dingdanMapper.selectAll();
    }

    @Transactional
    public PageResult queryByPage(DingdanQueryObject qo) {
        // TODO Auto-generated method stub
        //总数
        System.out.println("aaa");
        Long count = dingdanMapper.queryEorPageCount(qo);
        if (count == 0) {
            return new PageResult(0, Collections.EMPTY_LIST);
        }
        List<Dingdan> result = dingdanMapper.queryForPage(qo);
        return new PageResult(count.intValue(), result);


    }

}
