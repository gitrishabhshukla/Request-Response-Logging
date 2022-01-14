package com.practice.requestresponsedblogging.config;

import com.practice.requestresponsedblogging.filter.RequestResponseLoggerFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    FilterRegistrationBean<RequestResponseLoggerFilter> registrationBean(RequestResponseLoggerFilter loggerFilter){
        FilterRegistrationBean<RequestResponseLoggerFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(loggerFilter);
        registrationBean.addUrlPatterns("/student/save","/student/get");
        return registrationBean;
    }

}
