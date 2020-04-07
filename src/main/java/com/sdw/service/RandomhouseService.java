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
}
