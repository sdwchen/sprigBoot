package com.sdw.service;


import com.sdw.entity.Beforuser;
import com.sdw.entity.Book;
import com.sdw.mapper.BeforuserMapper;
import com.sdw.mapper.BookMapper;
import com.sdw.page.PageResult;
import com.sdw.query.BeforuserQueryObject;
import com.sdw.query.BookQueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class BeforuserService {
    @Autowired
    private BeforuserMapper beforuserMapper;

    @Transactional
    public int insert(Beforuser record) {
        // TODO Auto-generated method stub
        return beforuserMapper.insert(record);
    }

    @Transactional
    public Beforuser selectByPrimaryKey(Long id) {
        // TODO Auto-generated method stub
        return beforuserMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public int updateByPrimaryKey(Beforuser record) {
        // TODO Auto-generated method stub
        return beforuserMapper.updateByPrimaryKey(record);
    }

    @Transactional
    public int deleteByPrimaryKey(long id) {
        // TODO Auto-generated method stub
        return beforuserMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public PageResult queryByPage(BeforuserQueryObject qo) {
        // TODO Auto-generated method stub
        //总数
        Long count = beforuserMapper.queryEorPageCount(qo);

        if (count == 0) {
            return new PageResult(0, Collections.EMPTY_LIST);
        }
        List<Beforuser> result = beforuserMapper.queryForPage(qo);

        return new PageResult(count.intValue(), result);


    }

}
