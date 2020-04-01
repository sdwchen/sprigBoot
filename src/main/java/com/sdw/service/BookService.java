package com.sdw.service;


import com.sdw.entity.Book;
import com.sdw.entity.Dormitory;
import com.sdw.mapper.BookMapper;
import com.sdw.mapper.DormitoryMapper;
import com.sdw.page.PageResult;
import com.sdw.query.BookQueryObject;
import com.sdw.query.DormitoryQueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    @Transactional
    public int insert(Book record) {
        // TODO Auto-generated method stub
        return bookMapper.insert(record);
    }

    @Transactional
    public Book selectByPrimaryKey(Long id) {
        // TODO Auto-generated method stub
        return bookMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public int updateByPrimaryKey(Book record) {
        // TODO Auto-generated method stub
        return bookMapper.updateByPrimaryKey(record);
    }

    @Transactional
    public int deleteByPrimaryKey(long id) {
        // TODO Auto-generated method stub
        return bookMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public PageResult queryByPage(BookQueryObject qo) {
        // TODO Auto-generated method stub
        //总数
        Long count = bookMapper.queryEorPageCount(qo);

        if (count == 0) {
            return new PageResult(0, Collections.EMPTY_LIST);
        }
        List<Book> result = bookMapper.queryForPage(qo);

        return new PageResult(count.intValue(), result);


    }

}
