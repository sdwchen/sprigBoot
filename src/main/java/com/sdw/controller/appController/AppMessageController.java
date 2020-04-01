package com.sdw.controller.appController;


import com.sdw.entity.Message;
import com.sdw.page.AjaxResult;
import com.sdw.page.PageResult;
import com.sdw.query.MessageQueryObject;
import com.sdw.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
public class AppMessageController {

    @Autowired
    private MessageService messageService;


    //查询所有寝室信息加分页查询

    @RequestMapping("/messageList")
    public PageResult messagelist(MessageQueryObject qo) {
        System.out.println(qo);
        PageResult result = null;
        result = messageService.queryByPage(qo);
        return result;
    }
    //添加用户
    @RequestMapping("/messageSave")
    public AjaxResult save(Message message) {
        AjaxResult result = null;
        messageService.save(message);
        result = new AjaxResult(true, "保存成功");
        return result;

    }
    @RequestMapping("/allMessage")
    public List<Message> allMessageMsg(Message msg) {
        List<Message> result = null;
        result = messageService.allMessage(msg);
        return result;
    }
    //删除

    @RequestMapping("/messageDelete")
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        System.out.println(id);
        messageService.deleteByPrimaryKey(id);
        result = new AjaxResult(true, "删除成功");
        return result;
    }

}
