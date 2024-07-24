package com.giffing.wicket.spring.boot.starter.entity;

import java.io.Serializable;
import java.util.List;

public class Day implements Serializable {

    private String date;
    private List<Event> events;

    public Day(String date, List<Event> events) {
        this.date = date;
        this.events = events;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
