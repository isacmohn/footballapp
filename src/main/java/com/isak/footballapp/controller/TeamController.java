package com.isak.footballapp.controller;

import com.isak.footballapp.entity.Team;
import com.isak.footballapp.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }

    @PostMapping
    public Team save(@RequestBody Team team){
        return teamService.save(team);
    }

    @GetMapping
    public List<Team> findAll(){
        return teamService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Team> findById(@PathVariable Long id){
        return teamService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        teamService.deleteById(id);
    }
}