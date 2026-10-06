package com.isak.footballapp.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/* import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType; */

@Entity
public class Message {
    //Primary key i databasen
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //datafields tilsvarer egenskaper
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;
    
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private String content; 
    private LocalDateTime sentAt;
    private boolean isRead;

    //konstruktør som er tom
    public Message(){

    }

    public Message(User sender, User receiver, String content){
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;

        this.sentAt = LocalDateTime.now();
        this.isRead = false;
    }

    //gettere(+return, +samme datatype) og settere(+innargs, + void)
    public User getSender(){return sender;} public void setSender(User sender){this.sender = sender;}
    public User getReceiver(){return receiver;} public void setReceiver(User receiver){this.receiver = receiver;}
    public String getContent(){return content;} public void setContent(String content){this.content = content;}
    public LocalDateTime getSentAt(){return sentAt;} public void setSentAt(LocalDateTime sentAt){this.sentAt = sentAt;}
    public boolean isRead(){return isRead;} public void setIsRead(boolean isRead){this.isRead = isRead;}


    
}
