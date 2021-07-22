package com.example.MyWebApp.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class XssBean {
    private String userinput;

    public String getUserinput() {
        return userinput;
    }

    public void setUserinput(String input) {
        userinput = input;
    }
}
