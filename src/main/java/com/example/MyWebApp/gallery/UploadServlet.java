package com.example.MyWebApp.gallery;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "UploadServlet", value = "/UploadServlet")
@MultipartConfig()
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PhotoAlbum photoAlbum = PhotoAlbum.getPhotoAlbum(request.getSession());
        //if (request.getContentType() != null && request.getContentType().startsWith("multipath/form-data")) {
            uploadPhoto(request, photoAlbum);
        //}

        response.sendRedirect(request.getContextPath() + "/album.jsp");
    }

    private void uploadPhoto(HttpServletRequest request, PhotoAlbum photoAlbum) throws ServletException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String filename = null;
        for (Part p: request.getParts()) {
            copyBytes(p.getInputStream(), baos);
            filename = p.getSubmittedFileName();
        }
        if (!"".equals(filename)) {
            String photoName = filename.substring(0, filename.lastIndexOf("."));
            photoAlbum.addPhoto(photoName, baos.toByteArray());
        }
    }

    private void copyBytes(InputStream inputStream, ByteArrayOutputStream baos) throws IOException {
        int i;
        while ((i = inputStream.read()) != -1) {
            baos.write(i);
        }
        inputStream.close();
        baos.close();
    }
}
