package com.giffing.wicket.spring.boot.starter.entity;

import java.io.Serializable;

public class Event implements Serializable {

    private String time;
    private String description;
    private String details;

    public Event(String time, String description, String details) {
        this.time = time;
        this.description = description;
        this.details = details;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
