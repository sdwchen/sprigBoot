package com.sdw.controller;


import com.sdw.entity.Form;
import com.sdw.page.AjaxResult;
import com.sdw.page.PageResult;
import com.sdw.query.FormQueryObject;
import com.sdw.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class FormController {

    @Autowired
    private FormService formService;

    @RequestMapping("/form")
    public String userindex() {

        return "form";
    }
    //查询所有寝室信息加分页查询

    @RequestMapping("/form_list")
    @ResponseBody
    public PageResult formlist(FormQueryObject qo) {
        System.out.println(qo);
        PageResult result = null;
        //System.out.println(qo.getRows()+"----"+qo.getPage());
        result = formService.queryByPage(qo);
        return result;
    }

    //添加用户
    @RequestMapping("/form_save")
    @ResponseBody
    public AjaxResult save(Form form) {
        AjaxResult result = null;
        formService.insert(form);
        result = new AjaxResult(true, "保存成功");
        //result.put("success", true);
        //result.put("msg", "保存成功");
        return result;

    }

    //删除
    @ResponseBody
    @RequestMapping("/form_delete")
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        System.out.println(id);
        formService.deleteByPrimaryKey(id);
        result = new AjaxResult(true, "删除成功");

        return result;
    }

    //修改用户信息
    @RequestMapping("/form_update")
    @ResponseBody
    public AjaxResult update(Form form) {
        //Map<String,Object> result=new HashMap<String,Object>();
        AjaxResult result = null;
        formService.updateByPrimaryKey(form);
        result = new AjaxResult(true, "更新成功");
        return result;

    }

}
