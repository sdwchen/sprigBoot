package com.sdw.controller;


import com.sdw.entity.Clothes;
import com.sdw.page.AjaxResult;
import com.sdw.page.PageResult;

import com.sdw.query.ClothesQueryObject;
import com.sdw.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ClothesController {

    @Autowired
    private ClothesService clothesService;

    @RequestMapping("/clothes")
    public String userindex() {

        return "clothes";
    }
    //查询所有寝室信息加分页查询

    @RequestMapping("/clothes_list")
    @ResponseBody
    public PageResult clotheslist(ClothesQueryObject qo) {
        System.out.println(qo);
        PageResult result = null;
        //System.out.println(qo.getRows()+"----"+qo.getPage());
        result = clothesService.queryByPage(qo);
        return result;
    }

    //添加用户
    @RequestMapping("/clothes_save")
    @ResponseBody
    public AjaxResult save(Clothes clothes) {
        AjaxResult result = null;
        clothesService.insert(clothes);
        result = new AjaxResult(true, "保存成功");
        //result.put("success", true);
        //result.put("msg", "保存成功");
        return result;

    }

    //删除
    @ResponseBody
    @RequestMapping("/clothes_delete")
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        System.out.println(id);
        clothesService.deleteByPrimaryKey(id);
        result = new AjaxResult(true, "删除成功");

        return result;
    }

    //修改用户信息
    @RequestMapping("/clothes_update")
    @ResponseBody
    public AjaxResult update(Clothes clothes) {
        //Map<String,Object> result=new HashMap<String,Object>();
        AjaxResult result = null;
        clothesService.updateByPrimaryKey(clothes);
        result = new AjaxResult(true, "更新成功");
        return result;

    }

}
