package com.example.MyWebApp.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
@FacesConfig
public class ManagedPropertyBean {

    @Inject @ManagedProperty("#{param.nickname}")
    private String nickname;

    public void action() {
        System.out.println("Nickname: " + nickname);
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage("Submitted nickname: " + nickname);
        context.addMessage(null, message);
    }
}
