package com.sdw.service;


import com.sdw.entity.Book;
import com.sdw.entity.Others;
import com.sdw.mapper.BookMapper;
import com.sdw.mapper.OthersMapper;
import com.sdw.page.PageResult;
import com.sdw.query.BookQueryObject;
import com.sdw.query.OthersQueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class OthersService {
    @Autowired
    private OthersMapper othersMapper;

    @Transactional
    public int insert(Others record) {
        // TODO Auto-generated method stub
        return othersMapper.insert(record);
    }

    @Transactional
    public Others selectByPrimaryKey(Long id) {
        // TODO Auto-generated method stub
        return othersMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public int updateByPrimaryKey(Others record) {
        // TODO Auto-generated method stub
        return othersMapper.updateByPrimaryKey(record);
    }

    @Transactional
    public int deleteByPrimaryKey(long id) {
        // TODO Auto-generated method stub
        return othersMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public PageResult queryByPage(OthersQueryObject qo) {
        // TODO Auto-generated method stub
        //总数
        Long count = othersMapper.queryEorPageCount(qo);

        if (count == 0) {
            return new PageResult(0, Collections.EMPTY_LIST);
        }
        List<Others> result = othersMapper.queryForPage(qo);

        return new PageResult(count.intValue(), result);


    }

}
