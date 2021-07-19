package com.example.MyWebApp.hellojsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Max;

@Named
@RequestScoped
public class HelloBean {
    private String name = "dear reader";

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }
}
