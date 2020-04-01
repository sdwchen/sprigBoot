package com.sdw.service;

import java.util.List;

import com.sdw.entity.Menu;
import com.sdw.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MenuService {
    @Autowired
    private MenuMapper dao;

    @Transactional
    public List<Menu> selectRoot() {
        // TODO Auto-generated method stub;

        return dao.selectRoot();
    }

}
