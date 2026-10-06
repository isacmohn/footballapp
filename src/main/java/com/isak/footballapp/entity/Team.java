package com.isak.footballapp.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    //datafields tilsvarer egenskaper
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Pitch homePitch;

    @ManyToOne
    private User owner;
    
    @ManyToMany
    private List<User> members = new ArrayList<>();


    //konstruktører
    public Team(){

    }

    public Team(String name, Pitch homePitch, User owner){
        this.name = name;
        this.homePitch = homePitch;
        this.owner = owner;
        this.members.add(owner);
    
    }

    //gettere(+return, + samme datatype) og gettere(+void, +innargs)
    public String getName(){return name;} public void setName(String name){this.name = name;}
    public Pitch getHomePitch(){return homePitch;} public void setHomePitch(Pitch homePitch){this.homePitch = homePitch;}
    public User getOwner(){return owner;} public void setOwner(User owner){this.owner = owner;}
    public List<User> getMembers(){return members;} public void setMembers(List<User> members){this.members = members;}

}
