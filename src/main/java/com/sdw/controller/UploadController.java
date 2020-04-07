package com.sdw.controller;


import com.sdw.service.IQiniuUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;



@Controller
public class UploadController {

    @Autowired
    private IQiniuUploadFileService iQiniuUploadFileService;
    @Value("${qiniu.cdn.prefix}")
    private String url1;
    private String url="d://demp/";

    @PostMapping(value = "/uploadImg")
    @ResponseBody
    public Map<String,Object> uploadImg(@RequestParam(value = "file")MultipartFile upfile) throws IOException {
        Map<String,Object> map = new HashMap<>();
        String fileName = upfile.getOriginalFilename();
        File file = new File(url + fileName);
        try{
            //将MulitpartFile文件转化为file文件格式
            upfile.transferTo(file);
            Map response = iQiniuUploadFileService.uploadFile(file);
            Object imageName = response.get("imgName");
            System.out.println(url1+imageName);
            String url2=url1+imageName;
            map.put("url",url2);
            map.put("state","SUCESS");
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
}
