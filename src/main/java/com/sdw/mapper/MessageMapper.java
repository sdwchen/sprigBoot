package com.sdw.mapper;

import com.sdw.entity.Message;
import com.sdw.query.MessageQueryObject;

import java.util.List;

public interface MessageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Message record);
    int save(Message record);

    Message selectByPrimaryKey(Long id);

    List<Message> selectAll();
    List<Message> allMessage(Message msg);
    int updateByPrimaryKey(Message record);
    //高级查询加分页
    Long queryEorPageCount(MessageQueryObject qo);

    List<Message> queryForPage(MessageQueryObject qo);
}