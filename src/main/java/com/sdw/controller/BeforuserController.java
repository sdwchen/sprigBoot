package com.sdw.controller;


import com.sdw.entity.Beforuser;
import com.sdw.page.AjaxResult;
import com.sdw.page.PageResult;

import com.sdw.query.BeforuserQueryObject;
import com.sdw.service.BeforuserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BeforuserController {

    @Autowired
    private BeforuserService beforuserService;

    @RequestMapping("/beforuser")
    public String userindex() {

        return "beforuser";
    }
    //查询所有寝室信息加分页查询

    @RequestMapping("/beforuser_list")
    @ResponseBody
    public PageResult beforuserlist(BeforuserQueryObject qo) {
        System.out.println(qo);
        PageResult result = null;
        //System.out.println(qo.getRows()+"----"+qo.getPage());
        result = beforuserService.queryByPage(qo);
        return result;
    }

    //添加用户
    @RequestMapping("/beforuser_save")
    @ResponseBody
    public AjaxResult save(Beforuser beforuser) {
        AjaxResult result = null;
        beforuserService.insert(beforuser);
        result = new AjaxResult(true, "保存成功");

        return result;

    }

    //删除

    @RequestMapping("/beforuser_delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        System.out.println(id);
        beforuserService.deleteByPrimaryKey(id);
        result = new AjaxResult(true, "删除成功");
        return result;
    }

    //修改用户信息
    @RequestMapping("/beforuser_update")
    @ResponseBody
    public AjaxResult update(Beforuser beforuser) {
      //  Map<String,Object> result=new HashMap<String,Object>();
        AjaxResult result = null;
        beforuserService.updateByPrimaryKey(beforuser);
        result = new AjaxResult(true, "更新成功");
        return result;

    }

}
