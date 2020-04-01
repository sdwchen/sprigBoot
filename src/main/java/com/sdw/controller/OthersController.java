package com.sdw.controller;


import com.sdw.entity.Others;
import com.sdw.page.AjaxResult;
import com.sdw.page.PageResult;

import com.sdw.query.OthersQueryObject;

import com.sdw.service.OthersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class OthersController {

    @Autowired
    private OthersService othersService;

    @RequestMapping("/others")
    public String userindex() {

        return "others";
    }
    //查询所有寝室信息加分页查询

    @RequestMapping("/others_list")
    @ResponseBody
    public PageResult otherslist(OthersQueryObject qo) {
        System.out.println(qo);
        PageResult result = null;
        //System.out.println(qo.getRows()+"----"+qo.getPage());
        result = othersService.queryByPage(qo);
        return result;
    }

    //添加用户
    @RequestMapping("/others_save")
    @ResponseBody
    public AjaxResult save(Others others) {
        AjaxResult result = null;
        othersService.insert(others);
        result = new AjaxResult(true, "保存成功");
        //result.put("success", true);
        //result.put("msg", "保存成功");
        return result;

    }

    //删除
    @ResponseBody
    @RequestMapping("/others_delete")
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        System.out.println(id);
        othersService.deleteByPrimaryKey(id);
        result = new AjaxResult(true, "删除成功");

        return result;
    }

    //修改用户信息
    @RequestMapping("/others_update")
    @ResponseBody
    public AjaxResult update(Others others) {
        //Map<String,Object> result=new HashMap<String,Object>();
        AjaxResult result = null;
        othersService.updateByPrimaryKey(others);
        result = new AjaxResult(true, "更新成功");
        return result;

    }

}
