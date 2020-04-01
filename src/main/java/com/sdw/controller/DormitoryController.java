package com.sdw.controller;


import com.sdw.entity.Dormitory;
import com.sdw.entity.User;
import com.sdw.page.AjaxResult;
import com.sdw.page.PageResult;
import com.sdw.query.DormitoryQueryObject;

import com.sdw.service.DormitoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;

    @RequestMapping("/dormitory")
    public String userindex() {

        return "dormitory";
    }
    //查询所有寝室信息加分页查询

    @RequestMapping("/dormitory_list")
    @ResponseBody
    public PageResult dormitorylist(DormitoryQueryObject qo) {
        System.out.println(qo);
        PageResult result = null;
        //System.out.println(qo.getRows()+"----"+qo.getPage());
        result = dormitoryService.queryByPage(qo);
        return result;
    }

    //添加用户
    @RequestMapping("/dormitory_save")
    @ResponseBody
    public AjaxResult save(Dormitory dormitory) {
        AjaxResult result = null;
        dormitoryService.insert(dormitory);
        result = new AjaxResult(true, "保存成功");
        //result.put("success", true);
        //result.put("msg", "保存成功");
        return result;

    }

    //删除
    @ResponseBody
    @RequestMapping("/dormitory_delete")
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        System.out.println(id);
        dormitoryService.deleteByPrimaryKey(id);
        result = new AjaxResult(true, "删除成功");

        return result;
    }

    //修改用户信息
    @RequestMapping("/dormitory_update")
    @ResponseBody
    public AjaxResult update(Dormitory dormitory) {
        //Map<String,Object> result=new HashMap<String,Object>();
        AjaxResult result = null;
        dormitoryService.updateByPrimaryKey(dormitory);
        result = new AjaxResult(true, "更新成功");
        return result;

    }
    //编辑时显示数据，回显用户名
    @RequestMapping("/dormitory_queryForEmp")
    @ResponseBody
    public List<Dormitory> queryForEmp() {

        List<Dormitory> result = null;
        result = dormitoryService.listtAll();
        System.out.println(result);
        return result;

    }
}
