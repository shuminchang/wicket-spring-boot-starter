package com.giffing.wicket.spring.boot.starter.web.pages;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;

@WicketHomePage
public class HomePage extends WebPage {
    public HomePage() {
        add(new TripSchedulePanel("tripSchedulePanel"));
    }
}