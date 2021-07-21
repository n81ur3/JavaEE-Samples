package com.example.MyWebApp.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class NavigationBean {

    public void handleNavigation1() {
        String outcome = "surprise?faces-redirect=true";
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        NavigationHandler handler = application.getNavigationHandler();
        handler.handleNavigation(context, null, outcome);
    }

    public void handleNavigation2() throws IOException {
        String path = "/surprise.xhtml";
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        String uri = externalContext.getRequestContextPath() + path;
        externalContext.redirect(uri);
        //externalContext.redirect("https://www.orf.at");
    }
}
