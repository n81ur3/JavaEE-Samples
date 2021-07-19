package com.example.MyWebApp.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MyTimeSinceEpochTag extends SimpleTagSupport {
    @Override
    public void doTag() throws IOException, JspException {
        JspWriter out = getJspContext().getOut();
        out.print(System.currentTimeMillis());
    }
}
