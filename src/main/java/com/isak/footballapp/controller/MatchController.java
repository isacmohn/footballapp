package com.isak.footballapp.controller;

import com.isak.footballapp.entity.Match;
import com.isak.footballapp.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService){
        this.matchService = matchService;
    }

    @PostMapping
    public Match save(@RequestBody Match match){
        return matchService.save(match);
    }

    @GetMapping
    public List<Match> findAll(){
        return matchService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Match> findById(@PathVariable Long id){
        return matchService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        matchService.deleteById(id);
    }
}