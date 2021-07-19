package com.example.MyWebApp.gallery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveServlet", value = "/RemoveServlet")
public class RemoveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String indexString = request.getParameter("photo");
        int index = Integer.parseInt(indexString.trim());
        PhotoAlbum photoAlbum = PhotoAlbum.getPhotoAlbum(request.getSession());
        photoAlbum.removePhoto(index);
        RequestDispatcher rd = request.getRequestDispatcher("/album.jsp");
        rd.forward(request, response);

    }
}
