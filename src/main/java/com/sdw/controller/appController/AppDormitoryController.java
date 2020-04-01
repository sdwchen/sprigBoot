package com.sdw.controller.appController;

import com.sdw.entity.Dormitory;
import com.sdw.entity.User;
import com.sdw.page.AjaxResult;
import com.sdw.page.PageResult;
import com.sdw.query.DormitoryQueryObject;
import com.sdw.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class AppDormitoryController {
    @Autowired
    private DormitoryService dormitoryService;
    //    前端App接口查询所有地址，
    @RequestMapping("/dormitoryList")
    public PageResult dormitorylist(DormitoryQueryObject qo) {
        PageResult result = null;
        result = dormitoryService.queryByPage(qo);
        return result;
    }
    @RequestMapping("/updateLQ")
    public AjaxResult update(Dormitory dormitory){
        AjaxResult result = null;
        dormitoryService.updateLQ(dormitory);
        result = new AjaxResult(true, "修改成功");
        return result;
    }
    //删除

    @RequestMapping("/dormitoryDelete")
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        System.out.println(id);
        dormitoryService.deleteByPrimaryKey(id);
        result = new AjaxResult(true, "删除成功");
        return result;
    }
    //添加用户
    @RequestMapping("/dormitorySave")
    public AjaxResult save(Dormitory dormitory) {
        AjaxResult result = null;
        dormitoryService.add(dormitory);
        result = new AjaxResult(true, "保存成功");
        return result;
    }
}
