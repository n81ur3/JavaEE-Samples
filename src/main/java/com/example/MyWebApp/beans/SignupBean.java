package com.example.MyWebApp.beans;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class SignupBean implements Serializable {
    private final static long serialVersionUID = 1L;
    private String email = "current.email@gmail.com";

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
