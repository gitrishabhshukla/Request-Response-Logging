package com.practice.requestresponsedblogging.filter;

import lombok.Getter;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Getter
public class MyCustomHttpRequestWrapper extends HttpServletRequestWrapper {

    byte[] byteArray;

    public MyCustomHttpRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        byteArray = IOUtils.toByteArray(request.getInputStream());
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
       return new MyCustomDelegatingServletInputStream(new ByteArrayInputStream(byteArray));
    }
}
