package com.sdw.controller.appController;



import com.sdw.page.PageResult;
import com.sdw.query.InformationQueryObject;
import com.sdw.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class AppInformationController {

    @Autowired
    private InformationService informationService;
    @RequestMapping("/informationList")
    public PageResult informationlist(InformationQueryObject qo) {
        System.out.println(qo);
        PageResult result = null;
        result = informationService.queryByPage(qo);
        return result;
    }


}
