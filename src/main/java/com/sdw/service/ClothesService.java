package com.sdw.service;


import com.sdw.entity.Book;
import com.sdw.entity.Clothes;
import com.sdw.mapper.BookMapper;
import com.sdw.mapper.ClothesMapper;
import com.sdw.page.PageResult;
import com.sdw.query.BookQueryObject;
import com.sdw.query.ClothesQueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class ClothesService {
    @Autowired
    private ClothesMapper clothesMapper;

    @Transactional
    public int insert(Clothes record) {
        // TODO Auto-generated method stub
        return clothesMapper.insert(record);
    }

    @Transactional
    public Clothes selectByPrimaryKey(Long id) {
        // TODO Auto-generated method stub
        return clothesMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public int updateByPrimaryKey(Clothes record) {
        // TODO Auto-generated method stub
        return clothesMapper.updateByPrimaryKey(record);
    }

    @Transactional
    public int deleteByPrimaryKey(long id) {
        // TODO Auto-generated method stub
        return clothesMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public PageResult queryByPage(ClothesQueryObject qo) {
        // TODO Auto-generated method stub
        //总数
        Long count = clothesMapper.queryEorPageCount(qo);

        if (count == 0) {
            return new PageResult(0, Collections.EMPTY_LIST);
        }
        List<Clothes> result = clothesMapper.queryForPage(qo);

        return new PageResult(count.intValue(), result);


    }

}
