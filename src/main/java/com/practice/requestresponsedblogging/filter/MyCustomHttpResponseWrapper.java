package com.practice.requestresponsedblogging.filter;

import lombok.Getter;
import org.apache.commons.io.output.TeeOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

@Getter
public class MyCustomHttpResponseWrapper extends HttpServletResponseWrapper {

    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    private PrintStream printStream = new PrintStream(byteArrayOutputStream);

    public MyCustomHttpResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return new MyCustomDelegatingServletOutputStream(new TeeOutputStream(super.getOutputStream(),printStream));
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(new TeeOutputStream(super.getOutputStream(),printStream));
    }
}
