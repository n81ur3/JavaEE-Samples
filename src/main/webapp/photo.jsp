<%@ page import="com.example.MyWebApp.gallery.PhotoAlbum" %>
<%@ page contentType="image/jpg" language="java" %>
<%
    java.io.OutputStream binaryOut = response.getOutputStream();
    String indexString = request.getParameter("photo");
    int index = (new Integer(indexString.trim())).intValue();
    PhotoAlbum photo = PhotoAlbum.getPhotoAlbum(session);
    byte[] bytes = photo.getPhotoData(index);
    for (byte b : bytes) {
        binaryOut.write(b);
    }
    binaryOut.close();
%>