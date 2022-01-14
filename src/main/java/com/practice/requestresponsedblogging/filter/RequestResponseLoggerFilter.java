package com.practice.requestresponsedblogging.filter;

import com.practice.requestresponsedblogging.entity.Log;
import com.practice.requestresponsedblogging.repository.LogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class RequestResponseLoggerFilter implements Filter {

    @Autowired
    private LogRepository logRepository;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        MyCustomHttpRequestWrapper requestWrapper = new MyCustomHttpRequestWrapper((HttpServletRequest) request);
        MyCustomHttpResponseWrapper responseWrapper = new MyCustomHttpResponseWrapper((HttpServletResponse) response);

        Log logObj = new Log();
        logObj.setRequest(requestWrapper.getByteArray().toString());
        log.info("Request" + requestWrapper.getByteArray().toString());

        chain.doFilter(requestWrapper,responseWrapper);

        log.info("Status:" + responseWrapper.getStatus());
        logObj.setStatusCode(responseWrapper.getStatus());
        logObj.setResponse(responseWrapper.getByteArrayOutputStream().toString());

        logRepository.save(logObj);
    }
}