package com.sdw.controller.appController;

import com.sdw.entity.Appointment;
import com.sdw.page.AjaxResult;
import com.sdw.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class AppAppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @RequestMapping("/appointmentList")
    List<Appointment> selectAll(){
        return appointmentService.selectAll();
    }
    @RequestMapping("/insert")
    public AjaxResult insert(Appointment appointment){
        AjaxResult result=null;
        appointmentService.insert(appointment);
        result = new AjaxResult(true, "预约成功");
        return  result;
    }

}
