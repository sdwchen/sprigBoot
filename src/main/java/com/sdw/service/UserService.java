package com.sdw.service;


import com.sdw.page.PageResult;
import com.sdw.query.UserQueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sdw.entity.User;
import com.sdw.mapper.UserMapper;

import java.util.Collections;
import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public User findUsername(String username) {

        return userMapper.findByName(username);
    }

    @Transactional
    public int insert(User record) {
        // TODO Auto-generated method stub
        return userMapper.insert(record);
    }

    @Transactional
    public User selectByPrimaryKey(Integer userid) {
        // TODO Auto-generated method stub
        return userMapper.selectByPrimaryKey(userid);
    }

    @Transactional
    public int updateByPrimaryKey(User record) {
        // TODO Auto-generated method stub
        return userMapper.updateByPrimaryKey(record);
    }

    @Transactional
    public int deleteByPrimaryKey(Integer userid) {
        // TODO Auto-generated method stub
        return userMapper.deleteByPrimaryKey(userid);
    }

    @Transactional
    public PageResult queryByPage(UserQueryObject qo) {
        // TODO Auto-generated method stub
        //总数
        Long count = userMapper.queryEorPageCount(qo);
        if (count == 0) {
            return new PageResult(0, Collections.EMPTY_LIST);
        }
        List<User> result = userMapper.queryForPage(qo);
        return new PageResult(count.intValue(), result);
    }

    @Transactional
    public List<User> listtAll() {
        return userMapper.selectAll();
    }
    //App用户登录
    @Transactional
    public User login(String username,String password){
        return userMapper.login(username,password);
    }
    // 修改用户名和电话
    @Transactional
    public int updateNameTel(User record) {
        // TODO Auto-generated method stub
        return userMapper.updateNameTel(record);
    }
}
