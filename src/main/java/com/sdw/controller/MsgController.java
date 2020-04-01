package com.sdw.controller;


import com.sdw.entity.Msg;
import com.sdw.page.AjaxResult;
import com.sdw.page.PageResult;
import com.sdw.query.MsgQueryObject;
import com.sdw.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MsgController {

    @Autowired
    private MsgService msgService;

    @RequestMapping("/msg")
    public String userindex() {

        return "msg";
    }
    //查询所有寝室信息加分页查询

    @RequestMapping("/msg_list")
    @ResponseBody
    public PageResult msglist(MsgQueryObject qo) {
        System.out.println(qo);
        PageResult result = null;
        //System.out.println(qo.getRows()+"----"+qo.getPage());
        result = msgService.queryByPage(qo);
        return result;
    }

    //添加用户
    @RequestMapping("/msg_save")
    @ResponseBody
    public AjaxResult save(Msg msg) {
        AjaxResult result = null;
        msgService.insert(msg);
        result = new AjaxResult(true, "保存成功");

        return result;
    }

    //删除
    @ResponseBody
    @RequestMapping("/msg_delete")
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        System.out.println(id);
        msgService.deleteByPrimaryKey(id);
        result = new AjaxResult(true, "删除成功");

        return result;
    }

    //修改用户信息
    @RequestMapping("/msg_update")
    @ResponseBody
    public AjaxResult update(Msg msg) {
        //Map<String,Object> result=new HashMap<String,Object>();
        AjaxResult result = null;
        msgService.updateByPrimaryKey(msg);
        result = new AjaxResult(true, "更新成功");
        return result;

    }

}
