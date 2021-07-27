package com.example.MyWebApp.service;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserService {

    private List<String> registeredEmails;

    @PostConstruct
    public void init() {
        registeredEmails = new ArrayList<>();
        registeredEmails.add("h.bierbaumer@a1.net");
        registeredEmails.add("helmut.bierbaumer@gmail.com");
        registeredEmails.add("helmut.bierbaumer@edu.fh-joanneum.at");
    }

    public boolean exist(String email) {
        return registeredEmails.contains(email);
    }
}
