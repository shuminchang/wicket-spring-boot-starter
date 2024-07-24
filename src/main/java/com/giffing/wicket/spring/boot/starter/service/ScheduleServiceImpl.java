package com.giffing.wicket.spring.boot.starter.service;

import com.giffing.wicket.spring.boot.starter.dao.ScheduleDAO;
import com.giffing.wicket.spring.boot.starter.entity.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleDAO scheduleDAO;

    public ScheduleServiceImpl() {
        this.scheduleDAO = new ScheduleDAO();
    }

    @Override
    public List<Day> getSchedule() {
        return scheduleDAO.getScheduleData();
    }
}