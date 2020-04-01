package com.sdw.controller;


import com.sdw.entity.Book;

import com.sdw.page.AjaxResult;
import com.sdw.page.PageResult;
import com.sdw.query.BookQueryObject;


import com.sdw.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/book")
    public String userindex() {

        return "book";
    }
    //查询所有寝室信息加分页查询

    @RequestMapping("/book_list")
    @ResponseBody
    public PageResult booklist(BookQueryObject qo) {
        System.out.println(qo);
        PageResult result = null;
        //System.out.println(qo.getRows()+"----"+qo.getPage());
        result = bookService.queryByPage(qo);
        return result;
    }

    //添加用户
    @RequestMapping("/book_save")
    @ResponseBody
    public AjaxResult save(Book book) {
        AjaxResult result = null;
        bookService.insert(book);
        result = new AjaxResult(true, "保存成功");
        //result.put("success", true);
        //result.put("msg", "保存成功");
        return result;

    }

    //删除
    @ResponseBody
    @RequestMapping("/book_delete")
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        System.out.println(id);
        bookService.deleteByPrimaryKey(id);
        result = new AjaxResult(true, "删除成功");

        return result;
    }

    //修改用户信息
    @RequestMapping("/book_update")
    @ResponseBody
    public AjaxResult update(Book book) {
        //Map<String,Object> result=new HashMap<String,Object>();
        AjaxResult result = null;
        bookService.updateByPrimaryKey(book);
        result = new AjaxResult(true, "更新成功");
        return result;

    }

}
