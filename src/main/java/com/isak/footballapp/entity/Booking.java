package com.isak.footballapp.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Booking {
    //Private key til databasen
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Pitch pitch;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean status;
    
    //konstruktør tom
    public Booking(){

    }

    public Booking(User user, Pitch pitch, LocalDateTime startTime, LocalDateTime endTime, boolean status) {
        this.user = user;
        this.pitch = pitch;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    } 
    
    //gettere(+return, + samme datatype) og settere(+innargs, +void)
    public Long getBookingId(){return id;} public void setBookingId(Long id){this.id = id;}
    public User getUser(){return user;} public void setUser(User user){this.user = user;}
    public Pitch getPitch(){return pitch;} public void setPitch(Pitch pitch){this.pitch = pitch;}
    public LocalDateTime getStartTime(){return startTime;} public void setStartTime(LocalDateTime startTime){this.startTime = startTime;}
    public LocalDateTime getEndTime(){return endTime;} public void setEndTime(LocalDateTime endTime){this.endTime = endTime;}
    public boolean status(){return status;} public void setStatus(boolean status){this.status = status;}

}
