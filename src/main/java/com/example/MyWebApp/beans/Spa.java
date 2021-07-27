package com.example.MyWebApp.beans;

import javax.annotation.PostConstruct;
import javax.faces.annotation.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class Spa implements Serializable {
    private final static long serialVersionUID = 1L;

    @Inject
    @ManagedProperty("#{param.page}")
    private String page;

    @PostConstruct
    private void init() {
        if (page == null)
            page = "page1";
    }

    public void set(String newPage) {
        page = newPage;
    }

    public String getPage() {
        return page;
    }
}
