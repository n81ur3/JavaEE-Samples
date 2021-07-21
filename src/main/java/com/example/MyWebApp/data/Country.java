package com.example.MyWebApp.data;

import java.io.Serializable;

public class Country implements Serializable {
    private final static long serialVersionUID = 1L;

    private int id;
    private int code;
    private String name;

    public Country(int id, int code, String name) {
        setId(id);
        setCode(code);
        setName(name);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
