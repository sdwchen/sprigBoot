package com.sdw.service;


import com.sdw.entity.Msg;
import com.sdw.mapper.MsgMapper;
import com.sdw.page.PageResult;
import com.sdw.query.MsgQueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class MsgService {
    @Autowired
    private MsgMapper msgMapper;

    @Transactional
    public int insert(Msg record) {
        // TODO Auto-generated method stub
        return msgMapper.insert(record);
    }

    @Transactional
    public Msg selectByPrimaryKey(Long id) {
        // TODO Auto-generated method stub
        return msgMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public int updateByPrimaryKey(Msg record) {
        // TODO Auto-generated method stub
        return msgMapper.updateByPrimaryKey(record);
    }

    @Transactional
    public int deleteByPrimaryKey(long id) {
        // TODO Auto-generated method stub
        return msgMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public PageResult queryByPage(MsgQueryObject qo) {
        // TODO Auto-generated method stub
        //总数
        Long count = msgMapper.queryEorPageCount(qo);

        if (count == 0) {
            return new PageResult(0, Collections.EMPTY_LIST);
        }
        List<Msg> result = msgMapper.queryForPage(qo);

        return new PageResult(count.intValue(), result);

    }
    public List<Msg> allMsg(Msg msg){
      return   msgMapper.allMsg(msg);
    }
    public List<Msg> allMessageMsg(Msg msg){
        return   msgMapper.allMessageMsg(msg);
    }
}
