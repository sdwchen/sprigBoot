package com.sdw.mapper;

import java.util.List;

import com.sdw.query.UserQueryObject;
import org.apache.ibatis.annotations.Param;
import com.sdw.entity.User;

public interface UserMapper {
    // 查询语句
    //根据用户名查询用户
    User findByName(@Param("username") String username);

    int deleteByPrimaryKey(Integer userid);//删除

    int insert(User record);//添加

    User selectByPrimaryKey(Integer userid);//根据id查询

    List<User> selectAll();//查询所有

    int updateByPrimaryKey(User record);//更新

    //用户登录
    User login(@Param("username") String username, @Param("password") String password);
//修改用户名和密码
    int updateNameTel(User record);
    //高级查询加分页
    Long queryEorPageCount(UserQueryObject qo);

    List<User> queryForPage(UserQueryObject qo);

}
