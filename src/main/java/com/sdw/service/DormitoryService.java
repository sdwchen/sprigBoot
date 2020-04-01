package com.sdw.service;


import com.sdw.entity.Dormitory;
import com.sdw.mapper.DormitoryMapper;
import com.sdw.page.PageResult;
import com.sdw.query.DormitoryQueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class DormitoryService {
    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Transactional
    public int insert(Dormitory record) {
        // TODO Auto-generated method stub
        return dormitoryMapper.insert(record);
    }

    @Transactional
    public Dormitory selectByPrimaryKey(Long id) {
        // TODO Auto-generated method stub
        return dormitoryMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public int updateByPrimaryKey(Dormitory record) {
        // TODO Auto-generated method stub
        return dormitoryMapper.updateByPrimaryKey(record);
    }

    @Transactional
    public int deleteByPrimaryKey(long id) {
        // TODO Auto-generated method stub
        return dormitoryMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public PageResult queryByPage(DormitoryQueryObject qo) {
        // TODO Auto-generated method stub
        //总数
        Long count = dormitoryMapper.queryEorPageCount(qo);
        System.out.println(count);
        if (count == 0) {
            return new PageResult(0, Collections.EMPTY_LIST);
        }

        List<Dormitory> result = dormitoryMapper.queryForPage(qo);
        System.out.println("11111111111");
        return new PageResult(count.intValue(), result);


    }
    @Transactional
    public List<Dormitory> listtAll() {
        return dormitoryMapper.selectAll();
    }
    // 修改楼栋和宿舍
    @Transactional
    public int updateLQ(Dormitory record) {
        // TODO Auto-generated method stub
        return dormitoryMapper.updateLQ(record);
    }
    @Transactional
    public int add(Dormitory record) {
        // TODO Auto-generated method stub
        return dormitoryMapper.add(record);
    }
}
