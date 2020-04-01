package com.sdw.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.sdw.entity.Menu;
import com.sdw.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @ResponseBody
    @RequestMapping("/menu")

    public List<Menu> queryMenu(HttpSession session) {

        List<Menu> result = menuService.selectRoot();

        System.out.println(result);
        return result;
    }
}
