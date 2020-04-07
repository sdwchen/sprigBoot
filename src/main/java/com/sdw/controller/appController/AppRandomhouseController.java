package com.sdw.controller.appController;

import com.sdw.entity.Randomhouse;
import com.sdw.service.RandomhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppRandomhouseController {
    @Autowired
    private RandomhouseService randomhouseService;

    @RequestMapping("/randomhouseList")
    public List<Randomhouse> selectAll(){
        List<Randomhouse> result=randomhouseService.selectAll();
        return  result;
    }
}
