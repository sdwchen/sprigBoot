package com.sdw.controller.appController;


import com.sdw.entity.Form;
import com.sdw.page.AjaxResult;
import com.sdw.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//*
//
// 前端APp接口
// */
@RestController
@CrossOrigin//跨域
public class AppFormController {
    @Autowired
    private FormService formService;
    //添加订单
    @RequestMapping("/formAdd")
    public AjaxResult save(Form form, HttpServletRequest request) {
        System.out.println(form.getDormitory());
        String callback = request.getParameter("callback");
        AjaxResult result = null;
        formService.add(form);
        result = new AjaxResult(true, "保存成功");
        //result.put("success", true);
        //result.put("msg", "保存成功");
        return result;
    }
    //查询预约订单
    @RequestMapping("/findOrder")
    public List<Form> findOrder(Form form){
        List<Form> result=null;
        result=  formService.findOrder(form);
        return result;
    }
    // 预约成功订单
    @RequestMapping("/findAllOrder")
    public List<Form> findAllOrder(Form form){
        List<Form> result=null;
        result=  formService.findAllOrder(form);
        return result;
    }
    // 所有预约订单
    @RequestMapping("/findAll")
    public List<Form> findAll(Form form){
        List<Form> result=null;
        result=  formService.findAll(form);
        return result;
    }
}
