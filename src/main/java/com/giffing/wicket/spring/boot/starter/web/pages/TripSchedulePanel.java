package com.giffing.wicket.spring.boot.starter.web.pages;

import com.giffing.wicket.spring.boot.starter.entity.Day;
import com.giffing.wicket.spring.boot.starter.entity.Event;
import com.giffing.wicket.spring.boot.starter.service.ScheduleService;
import com.giffing.wicket.spring.boot.starter.service.ScheduleServiceImpl;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@ComponentScan
public class TripSchedulePanel extends Panel {

    @SpringBean
    private ScheduleService scheduleService;
    public TripSchedulePanel(String id) {
        super(id);
        add(new Label("title", "Trip Schedule"));

//        List<Map<String, Object>> days = getScheduleData();

        List<Day> days = scheduleService.getSchedule();

        ListView<Day> scheduleListView = new ListView<>("scheduleListView", Model.ofList(days)) {
            @Override
            protected void populateItem(ListItem<Day> item) {
                Day day = item.getModelObject();
                item.add(new Label("date", day.getDate()));

                ListView<Event> eventListView = new ListView<Event>("eventListView", Model.ofList(day.getEvents())) {
                    @Override
                    protected void populateItem(ListItem<Event> item) {
                        Event event = item.getModelObject();
                        item.add(new Label("time", event.getTime()));
                        item.add(new Label("description", event.getDescription()));
                        item.add(new Label("details", event.getDetails()));
                    }
                };
                item.add(eventListView);
            }
        };
        add(scheduleListView);

//        ListView<Map<String, Object>> scheduleListView = new ListView<>("scheduleListView", Model.ofList(days)) {
//            @Override
//            protected void populateItem(ListItem<Map<String, Object>> item) {
//                Map<String, Object> day = item.getModelObject();
//                item.add(new Label("date", (String) day.get("date")));
//
//                List<Map<String, String>> events = (List<Map<String, String>>) day.get("events");
//
//                ListView<Map<String, String>> eventListView = new ListView<Map<String, String>>("eventListView", Model.ofList(events)) {
//                    @Override
//                    protected void populateItem(ListItem<Map<String, String>> item) {
//                        Map<String, String> event = item.getModelObject();
//                        item.add(new Label("time", event.get("time")));
//                        item.add(new Label("description", event.get("description")));
//                        item.add(new Label("details", event.get("details")));
//                    }
//                };
//                item.add(eventListView);
//            }
//        };
//        add(scheduleListView);
    }

    /**
     * Loads the schedule data.
     *
     * @return A list of maps representing the schedule
     * "date": String representing the date
     * "events": List of maps, each representing an event
     * - Each event map has keys:
     * - "time": String representing the time of the event
     *   - "description": String describing the event
     *   - "details": String with additional details about the event
     */
    private List<Map<String, Object>> getScheduleData() {
        List<Map<String, Object>> schedule = new ArrayList<>();

        Map<String, Object> day1 = new HashMap<>();
        day1.put("date", "2024-07-24");

        List<Map<String, String>> events1 = new ArrayList<>();
        Map<String, String> event1 = new HashMap<>();
        event1.put("time", "08:00");
        event1.put("description", "Flight to Tokyo");
        event1.put("details", "passport, boarding pass, luggage");
        events1.add(event1);

        Map<String, String> event2 = new HashMap<>();
        event2.put("time", "13:00");
        event2.put("description", "Launch in Tokyo");
        event2.put("details", "Try sushi at Tsukiji market");
        events1.add(event2);

        day1.put("events", events1);
        schedule.add(day1);

        return schedule;
    }
}
