package com.sdw.controller;

import com.sdw.page.PageResult;
import com.sdw.query.UserQueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;


import com.sdw.entity.User;
import com.sdw.page.AjaxResult;
import com.sdw.service.UserService;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Controller
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public String userindex() {

        return "user";
    }
    //删除
    @ResponseBody
    @RequestMapping("/user_delete")
    public AjaxResult delete(int id) {
        AjaxResult result = null;
        System.out.println(id);
        userService.deleteByPrimaryKey(id);
        result = new AjaxResult(true, "删除成功");
        return result;
    }

    //添加用户
    @RequestMapping("/user_save")
    @ResponseBody
    public AjaxResult save(User user) {
        AjaxResult result = null;
        userService.insert(user);
        result = new AjaxResult(true, "保存成功");

        return result;

    }

    //修改用户信息
    @RequestMapping("/user_update")
    @ResponseBody
    public AjaxResult update(User user) {
        //Map<String,Object> result=new HashMap<String,Object>();
        AjaxResult result = null;
        userService.updateByPrimaryKey(user);
        result = new AjaxResult(true, "更新成功");

        //result.put("success", true);
        //result.put("msg", "更新成功")；
        return result;

    }

    //查询所有用户加分页查询
    @RequestMapping("/user_list")
    @ResponseBody
    public PageResult list(UserQueryObject qo) {
        PageResult result = null;
        //System.out.println(qo.getRows()+"----"+qo.getPage());
        result = userService.queryByPage(qo);
        return result;
    }

    //编辑时显示数据，回显用户名
    @RequestMapping("/user_queryForEmp")
    @ResponseBody
    public List<User> queryForEmp() {

        List<User> result = null;
        result = userService.listtAll();
        System.out.println(result);
        return result;

    }


}
