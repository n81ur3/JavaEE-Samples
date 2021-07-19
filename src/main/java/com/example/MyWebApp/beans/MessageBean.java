package com.example.MyWebApp.beans;

import com.example.MyWebApp.data.Message;
import com.example.MyWebApp.service.MessageService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class MessageBean {
    private Message message = new Message();
    private List<Message> messages;

    @Inject
    private MessageService messageService;

    @PostConstruct
    public void init() {
        messages = messageService.list();
    }

    public Message getMessage() {
        return message;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void submit() {
        messageService.create(message);
        messages.add(message);
    }
}
