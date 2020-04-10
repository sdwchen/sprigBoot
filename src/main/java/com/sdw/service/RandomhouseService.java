package com.sdw.service;

import com.sdw.entity.Randomhouse;
import com.sdw.mapper.RandomhouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RandomhouseService {
    @Autowired
    private RandomhouseMapper randomhouseMapper;

    @Transactional
   public List<Randomhouse> selectAll(){
        return randomhouseMapper.selectAll();
    }
    @Transactional
    public int updateState(Randomhouse randomhouse){
      return   randomhouseMapper.updateState(randomhouse);
    }
    @Transactional
    public int updateByPrimaryKey(Randomhouse record) {
        // TODO Auto-generated method stub
        return randomhouseMapper.updateByPrimaryKey(record);
    }
    @Transactional
    public int insert(Randomhouse record) {
        // TODO Auto-generated method stub
        return randomhouseMapper.insert(record);
    }

}
