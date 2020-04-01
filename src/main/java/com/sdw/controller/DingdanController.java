package com.sdw.controller;


import com.sdw.entity.Dingdan;
import com.sdw.page.AjaxResult;
import com.sdw.page.PageResult;

import com.sdw.query.DingdanQueryObject;
import com.sdw.service.DingdanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class DingdanController {

    @Autowired
    private DingdanService dingdanService;

    @RequestMapping("/dingdan")
    public String userindex() {

        return "dingdan";
    }
    //查询所有寝室信息加分页查询

    @RequestMapping("/dingdan_list")
    @ResponseBody
    public PageResult dingdanlist(DingdanQueryObject qo) {
        System.out.println(qo);
        PageResult result = null;

        result = dingdanService.queryByPage(qo);
        return result;
    }

    //删除
    @ResponseBody
    @RequestMapping("/dingdan_delete")
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        System.out.println(id);
        dingdanService.deleteByPrimaryKey(id);
        result = new AjaxResult(true, "删除成功");

        return result;
    }

    //修改用户信息
    @RequestMapping("/dingdan_update")
    @ResponseBody
    public AjaxResult update(Dingdan dingdan) {
        //Map<String,Object> result=new HashMap<String,Object>();
        AjaxResult result = null;
        dingdanService.updateByPrimaryKey(dingdan);
        result = new AjaxResult(true, "更新成功");
        return result;

    }

    //添加用户
    @RequestMapping("/dingdan_save")
    @ResponseBody
    public AjaxResult save(Dingdan dingdan) {
        AjaxResult result = null;
        dingdanService.insert(dingdan);
        result = new AjaxResult(true, "保存成功");
        //result.put("success", true);
        //result.put("msg", "保存成功");
        return result;

    }

    //编辑时显示数据，回显用户名
    @RequestMapping("/dingdan_queryForEmp")
    @ResponseBody
    public List<Dingdan> queryForEmp() {
        List<Dingdan> result = null;
        result = dingdanService.selectAll();
        System.out.println(result);
        return result;

    }


}
