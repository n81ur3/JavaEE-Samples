package com.example.MyWebApp.gallery;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class PhotoAlbum {
    public static String ATTRIBUTE_NAME = "Photo_Album";
    private List<byte[]> photoDataList = new ArrayList<>();
    private List<String> names = new ArrayList<>();

    public PhotoAlbum() {}

    public void setSession(HttpSession session) {
        session.setAttribute(ATTRIBUTE_NAME, this);
    }

    public List getPhotoNames() {
        return names;
    }

    public void addPhoto(String name, byte[] bytes) {
        photoDataList.add(bytes);
        names.add(name);
    }

    public byte[] getPhotoData(int i) {
        return photoDataList.get(i);
    }

    public String getPhotoName(int i) {
        return names.get(i);
    }

    public int getPhotoCount() {
        return names.size();
    }

    public void removePhoto(int i) {
        photoDataList.remove(i);
        names.remove(i);
    }

    public static PhotoAlbum getPhotoAlbum(HttpSession session) {
        return (PhotoAlbum) session.getAttribute(ATTRIBUTE_NAME);
    }
}
