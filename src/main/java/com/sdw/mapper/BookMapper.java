package com.sdw.mapper;

import com.sdw.entity.Book;
import com.sdw.query.BookQueryObject;

import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Book record);

    Book selectByPrimaryKey(Long id);

    List<Book> selectAll();

    int updateByPrimaryKey(Book record);

    //高级查询加分页
    Long queryEorPageCount(BookQueryObject qo);

    List<Book> queryForPage(BookQueryObject qo);
}