package com.giffing.wicket.spring.boot.starter.service;

import com.giffing.wicket.spring.boot.starter.entity.Day;

import java.util.List;

public interface ScheduleService {
    List<Day> getSchedule();
}