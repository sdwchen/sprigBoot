package com.sdw.controller;


import com.sdw.entity.Message;
import com.sdw.page.AjaxResult;
import com.sdw.page.PageResult;
import com.sdw.query.MessageQueryObject;
import com.sdw.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/message")
    public String userindex() {

        return "message";
    }
    //查询所有寝室信息加分页查询

    @RequestMapping("/message_list")
    @ResponseBody
    public PageResult messagelist(MessageQueryObject qo) {
        System.out.println(qo);
        PageResult result = null;
        //System.out.println(qo.getRows()+"----"+qo.getPage());
        result = messageService.queryByPage(qo);
        return result;
    }

    //添加用户
    @RequestMapping("/message_save")
    @ResponseBody
    public AjaxResult save(Message message) {
        AjaxResult result = null;
        messageService.insert(message);
        result = new AjaxResult(true, "保存成功");
        //result.put("success", true);
        //result.put("msg", "保存成功");
        return result;

    }

    //删除
    @ResponseBody
    @RequestMapping("/message_delete")
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        System.out.println(id);
        messageService.deleteByPrimaryKey(id);
        result = new AjaxResult(true, "删除成功");

        return result;
    }

    //修改用户信息
    @RequestMapping("/message_update")
    @ResponseBody
    public AjaxResult update(Message message) {
        //Map<String,Object> result=new HashMap<String,Object>();
        AjaxResult result = null;
        messageService.updateByPrimaryKey(message);
        result = new AjaxResult(true, "更新成功");
        return result;

    }

}
