package com.example.MyWebApp.partyjsf;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class PartyBean implements Serializable {
    private String name;
    private boolean parentsAllowed;
    private List<Guest> items;
    private String imageUri;

    public PartyBean() {
        reset();
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String newUri) {
        imageUri = newUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public boolean getParentsAllowed() {
        return parentsAllowed;
    }

    public void setParentsAllowed(boolean allowed) {
        parentsAllowed = allowed;
    }

    public List<Guest> getItems() {
        return items;
    }

    public void reset() {
       name = "(party title)";
       parentsAllowed = false;
       items = new ArrayList<>();
       items.add(new Guest("Sally", 6));
       items.add(new Guest("Nithan", 7));
       items.add(new Guest("Julia", 4));
       imageUri = "/party/images/balloons.jpg";
    }

    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("My party is called " + name);
        sb.append(", ");
        sb.append(" there are " + items.size() + " guests");
        sb.append(", and parents are " + (parentsAllowed ? "" : "not") + " allowed to stay.");

        return sb.toString();
    }
}
