package com.giffing.wicket.spring.boot.starter;

import com.giffing.wicket.spring.boot.starter.web.pages.HomePage;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WicketApplication extends SpringBootServletInitializer {
    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder()
                .sources(WicketApplication.class)
                .run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WicketApplication.class);
    }

    public static class MyWebApplication extends WebApplication {
        @Override
        public Class<? extends Page> getHomePage() {
            return HomePage.class;
        }

        @Override
        public void init() {
            super.init();
            getComponentInstantiationListeners().add(new SpringComponentInjector(this));
        }
    }
}