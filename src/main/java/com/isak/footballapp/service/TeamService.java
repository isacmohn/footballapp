package com.isak.footballapp.service;

import com.isak.footballapp.entity.Team;
import com.isak.footballapp.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    public Team save(Team team){
        return teamRepository.save(team);
    }

    public List<Team> findAll(){
        return teamRepository.findAll();
    }

    public Optional<Team> findById(Long id){
        return teamRepository.findById(id);
    }

    public void deleteById(Long id){
        teamRepository.deleteById(id);
    }
}