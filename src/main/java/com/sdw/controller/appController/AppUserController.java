package com.sdw.controller.appController;

import com.sdw.entity.User;
import com.sdw.page.AjaxResult;
import com.sdw.page.PageResult;
import com.sdw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
* @RestController 相当于@Contoller和@ResponseBody注解
*
* */
@RestController
@CrossOrigin//允许跨域
public class AppUserController {
    @Autowired
    private UserService userService;
    //前端接口
    //根据用户名查询用户

    @RequestMapping("/findUsername")
    public AjaxResult getFindbyUsername(String username, HttpServletRequest request) {
        String callback = request.getParameter("callback");
        AjaxResult result=null;
        User user =  userService.findUsername(username);
        if(user!=null){
         result = new AjaxResult(true, "用户名已存在");
     }else {
         result = new AjaxResult(false, "用户名不存在");
     }
        return result;
    }
    @RequestMapping("/find_username")
    public User FindbyUsername(String username) {
        User user =  userService.findUsername(username);
        return user;
    }
    @RequestMapping("/userLogin")
    public AjaxResult login(String username,String password, HttpServletRequest request){
        String callback = request.getParameter("callback");
        AjaxResult result = null;
       User user= userService.login(username,password);
       if(user!=null){
           result = new AjaxResult(true, "登录成功");
       }else{
           result = new AjaxResult(false, "登录失败");
        }
        return result;
    }
    //注册用户
    @RequestMapping("/regist")
    public AjaxResult save(User user) {
        AjaxResult result = null;
        userService.insert(user);
        result = new AjaxResult(true, "保存成功");
        return result;

    }
    @RequestMapping("/updateNameTel")
    public AjaxResult update(User user){
        AjaxResult result = null;
        userService.updateNameTel(user);
        result = new AjaxResult(true, "修改成功");
        return result;
    }
    //修改用户信息
    @RequestMapping("/userUpdate")
    public AjaxResult updateUser(User user) {
        AjaxResult result = null;
        userService.updateByPrimaryKey(user);
        result = new AjaxResult(true, "更新成功");
        return result;
    }
    @RequestMapping("/findId")
    public User FindId(Integer userid) {
        User user =  userService.selectByPrimaryKey(userid);
        return user;
    }
}
