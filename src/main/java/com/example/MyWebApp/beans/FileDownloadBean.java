package com.example.MyWebApp.beans;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class FileDownloadBean {
    private StreamedContent file;

    @PostConstruct
    private void init() {
        file = DefaultStreamedContent.builder()
                .name("downloaded_image.jpg")
                .contentType("image/jpg")
                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/sample-image.jpg"))
                .build();
    }

    public StreamedContent getFile() {
        return file;
    }
}
