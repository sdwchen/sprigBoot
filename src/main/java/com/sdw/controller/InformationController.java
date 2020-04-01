package com.sdw.controller;


import com.sdw.entity.Information;
import com.sdw.page.AjaxResult;
import com.sdw.page.PageResult;
import com.sdw.query.InformationQueryObject;
import com.sdw.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class InformationController {

    @Autowired
    private InformationService informationService;

    @RequestMapping("/information")
    public String userindex() {

        return "information";
    }
    //查询所有寝室信息加分页查询

    @RequestMapping("/information_list")
    @ResponseBody
    public PageResult informationlist(InformationQueryObject qo) {
        System.out.println(qo);
        PageResult result = null;
        //System.out.println(qo.getRows()+"----"+qo.getPage());
        result = informationService.queryByPage(qo);
        return result;
    }

    //添加用户
    @RequestMapping("/information_save")
    @ResponseBody
    public AjaxResult save(Information information) {
        AjaxResult result = null;
        informationService.insert(information);
        result = new AjaxResult(true, "保存成功");

        return result;

    }

    //删除

    @RequestMapping("/information_delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        System.out.println(id);
        informationService.deleteByPrimaryKey(id);
        result = new AjaxResult(true, "删除成功");
        return result;
    }

    //修改用户信息
    @RequestMapping("/information_update")
    @ResponseBody
    public AjaxResult update(Information information) {
      //  Map<String,Object> result=new HashMap<String,Object>();
        AjaxResult result = null;
        informationService.updateByPrimaryKey(information);
        result = new AjaxResult(true, "更新成功");
        return result;

    }

}
