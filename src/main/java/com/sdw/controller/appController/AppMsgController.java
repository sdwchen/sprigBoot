package com.sdw.controller.appController;


import com.sdw.entity.Msg;
import com.sdw.page.AjaxResult;
import com.sdw.page.PageResult;
import com.sdw.query.MsgQueryObject;
import com.sdw.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
public class AppMsgController {

    @Autowired
    private MsgService msgService;
    @RequestMapping("/msgList")
    public List<Msg> msgList(Msg msg) {

        List<Msg> result = null;
        result = msgService.allMsg(msg);
        return result;
    }
    @RequestMapping("/allMessageMsg")
    public List<Msg> allMessageMsg(Msg msg) {
        List<Msg> result = null;
        result = msgService.allMessageMsg(msg);
        return result;
    }

    //添加用户
    @RequestMapping("/msgSave")
    public AjaxResult save(Msg msg) {
        AjaxResult result = null;
        msgService.insert(msg);
        result = new AjaxResult(true, "保存成功");
        return result;
    }

}
