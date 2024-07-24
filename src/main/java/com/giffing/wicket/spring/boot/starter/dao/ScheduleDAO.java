package com.giffing.wicket.spring.boot.starter.dao;

import com.giffing.wicket.spring.boot.starter.entity.Day;
import com.giffing.wicket.spring.boot.starter.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class ScheduleDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Day> getScheduleData() {
        String sql = "SELECT date, time, description, details FROM schedule ORDER BY date, time";

        List<Day> schedule = new ArrayList<>();
        Map<String, Day> dayMap = new HashMap<>();

        jdbcTemplate.query(sql, new RowMapper<Void>() {
            @Override
            public Void mapRow(ResultSet rs, int rowNum) throws SQLException {
                String date = rs.getString("date");
                String time = rs.getString("time");
                String description = rs.getString("description");
                String details = rs.getString("details");

                Day day = dayMap.get(date);
                if (day == null) {
                    day = new Day(date, new ArrayList<>());
                    dayMap.put(date, day);
                    schedule.add(day);
                }

                Event event = new Event(time, description, details);
                day.getEvents().add(event);
                return null;
            }
        });

        return schedule;
    }
}