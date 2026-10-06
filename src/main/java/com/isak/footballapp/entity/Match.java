package com.isak.footballapp.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Team homeTeam;

    @ManyToOne
    private Team awayTeam;

    @ManyToOne
    private Pitch pitch;

    private LocalDateTime matchTime;

    private Integer homeScore;

    private Integer awayScore;

    public Match(){}

    public Match(Team homeTeam, Team awayTeam, Pitch pitch, LocalDateTime matchTime){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.pitch = pitch;
        this.matchTime = matchTime;
    }

    // Gettere og settere
    public Team getHomeTeam(){ return homeTeam; } public void setHomeTeam(Team homeTeam){ this.homeTeam = homeTeam; }

    public Team getAwayTeam(){ return awayTeam; } public void setAwayTeam(Team awayTeam){ this.awayTeam = awayTeam; }

    public Pitch getPitch(){ return pitch; } public void setPitch(Pitch pitch){ this.pitch = pitch; }

    public LocalDateTime getMatchTime(){ return matchTime; } public void setMatchTime(LocalDateTime matchTime){ this.matchTime = matchTime; }

    public Integer getHomeScore(){ return homeScore; } public void setHomeScore(Integer homeScore){ this.homeScore = homeScore; }

    public Integer getAwayScore(){ return awayScore; } public void setAwayScore(Integer awayScore){ this.awayScore = awayScore; }
}
