package com.example.MyWebApp.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginBean {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String submit() {
        if (email.equals("admin") && password.equals("admin")) {
            return "surprise?faces-redirect=true";
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage("Authentication failed");
            context.addMessage("login:submit", message);
            FacesMessage loginFailed = new FacesMessage("Login Process failed");
            context.addMessage(null, loginFailed);
            return "";
        }
    }
}
