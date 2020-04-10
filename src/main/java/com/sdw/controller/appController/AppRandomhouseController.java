package com.sdw.controller.appController;

import com.sdw.entity.Randomhouse;
import com.sdw.page.AjaxResult;
import com.sdw.service.RandomhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class AppRandomhouseController {
    @Autowired
    private RandomhouseService randomhouseService;

    @RequestMapping("/randomhouseList")
    public List<Randomhouse> selectAll(){
        List<Randomhouse> result=randomhouseService.selectAll();
        return  result;
    }
    @RequestMapping("/updateState")
    public AjaxResult updateState(Randomhouse randomhouse){
        AjaxResult result=null;
        randomhouseService.updateState(randomhouse);
        result = new AjaxResult(true, "修改成功");
        return result;
    }
    @RequestMapping("/update")
    public AjaxResult update(Randomhouse randomhouse){
        AjaxResult result=null;
        randomhouseService.updateByPrimaryKey(randomhouse);
        result = new AjaxResult(true, "添加成功");
        return result;
    }
    @RequestMapping("/save")
    public AjaxResult save(Randomhouse randomhouse){
        AjaxResult result=null;
        randomhouseService.insert(randomhouse);
        result = new AjaxResult(true, "添加成功");
        return result;
    }
}
