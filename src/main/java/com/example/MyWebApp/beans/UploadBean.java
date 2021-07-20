package com.example.MyWebApp.beans;

import org.primefaces.model.file.UploadedFile;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.*;

@Named
@RequestScoped
public class UploadBean {
    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void uploadFile() {
        if (file != null) {
            try {
                copyFile();
            } catch (Exception exc) {
                FacesMessage errorMessage = new FacesMessage("Error", file.getFileName() + "failed to upload");
                FacesContext.getCurrentInstance().addMessage(null, errorMessage);
            }
            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    private void copyFile() throws IOException {
        OutputStream out = new FileOutputStream(new File("/tmp", file.getFileName()));
        InputStream in = file.getInputStream();

        byte[] bytes = new byte[1024];

        while ((in.read(bytes)) != -1) {
            out.write(bytes);
        }

        in.close();
        out.flush();
        out.close();
    }
}
