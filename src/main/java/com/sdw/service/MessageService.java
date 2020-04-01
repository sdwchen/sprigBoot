package com.sdw.service;


import com.sdw.entity.Message;

import com.sdw.mapper.MessageMapper;
import com.sdw.page.PageResult;

import com.sdw.query.MessageQueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Transactional
    public int insert(Message record) {
        // TODO Auto-generated method stub
        return messageMapper.insert(record);
    }
    @Transactional
    public int save(Message record) {
        // TODO Auto-generated method stub
        return messageMapper.save(record);
    }
    @Transactional
    public Message selectByPrimaryKey(Long id) {
        // TODO Auto-generated method stub
        return messageMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public int updateByPrimaryKey(Message record) {
        // TODO Auto-generated method stub
        return messageMapper.updateByPrimaryKey(record);
    }

    @Transactional
    public int deleteByPrimaryKey(long id) {
        // TODO Auto-generated method stub
        return messageMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public PageResult queryByPage(MessageQueryObject qo) {
        // TODO Auto-generated method stub
        //总数
        Long count = messageMapper.queryEorPageCount(qo);

        if (count == 0) {
            return new PageResult(0, Collections.EMPTY_LIST);
        }
        List<Message> result = messageMapper.queryForPage(qo);

        return new PageResult(count.intValue(), result);


    }
    public List<Message> allMessage(Message msg){
        return   messageMapper.allMessage(msg);
    }

}
