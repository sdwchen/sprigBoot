package com.sdw.service;

import com.sdw.entity.Appointment;
import com.sdw.mapper.AppointmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentMapper appointmentMapper;
    @Transactional
    public int insert(Appointment record) {
        // TODO Auto-generated method stub
        return appointmentMapper.insert(record);
    }

    @Transactional
    public Appointment selectByPrimaryKey(Long id) {
        // TODO Auto-generated method stub
        return appointmentMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public int updateByPrimaryKey(Appointment record) {
        // TODO Auto-generated method stub
        return appointmentMapper.updateByPrimaryKey(record);
    }

    @Transactional
    public int deleteByPrimaryKey(long id) {
        // TODO Auto-generated method stub
        return appointmentMapper.deleteByPrimaryKey(id);
    }
    @Transactional
    public  List<Appointment> selectAll(){
        return appointmentMapper.selectAll();
    }
}
