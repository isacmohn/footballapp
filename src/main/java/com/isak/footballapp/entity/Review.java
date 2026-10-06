package com.isak.footballapp.entity;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User author;

    @ManyToOne
    private Pitch pitch;

    private Integer rating;

    private String comment;

    public Review(){}

    public Review(User author, Pitch pitch, Integer rating, String comment){
        this.author = author;
        this.pitch = pitch;
        this.rating = rating;
        this.comment = comment;
    }

    // Gettere og settere
    public User getAuthor(){ return author; }
    public void setAuthor(User author){ this.author = author; }

    public Pitch getPitch(){ return pitch; }
    public void setPitch(Pitch pitch){ this.pitch = pitch; }

    public Integer getRating(){ return rating; }
    public void setRating(Integer rating){ this.rating = rating; }

    public String getComment(){ return comment; }
    public void setComment(String comment){ this.comment = comment; }
}