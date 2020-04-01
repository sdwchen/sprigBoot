package com.sdw.service;


import com.sdw.entity.Information;
import com.sdw.mapper.InformationMapper;
import com.sdw.page.PageResult;
import com.sdw.query.InformationQueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class InformationService {
    @Autowired
    private InformationMapper informationMapper;

    @Transactional
    public int insert(Information record) {
        // TODO Auto-generated method stub
        return informationMapper.insert(record);
    }

    @Transactional
    public Information selectByPrimaryKey(Long id) {
        // TODO Auto-generated method stub
        return informationMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public int updateByPrimaryKey(Information record) {
        // TODO Auto-generated method stub
        return informationMapper.updateByPrimaryKey(record);
    }

    @Transactional
    public int deleteByPrimaryKey(long id) {
        // TODO Auto-generated method stub
        return informationMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public PageResult queryByPage(InformationQueryObject qo) {
        // TODO Auto-generated method stub
        //总数
        Long count = informationMapper.queryEorPageCount(qo);

        if (count == 0) {
            return new PageResult(0, Collections.EMPTY_LIST);
        }
        List<Information> result = informationMapper.queryForPage(qo);

        return new PageResult(count.intValue(), result);


    }

}
