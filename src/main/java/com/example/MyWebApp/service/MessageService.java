package com.example.MyWebApp.service;

import com.example.MyWebApp.data.Message;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MessageService {
    
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Message message) {
        entityManager.persist(message);
    }

    public List<Message> list() {
        return entityManager.createQuery("FROM Message m", Message.class).getResultList();
    }
}
