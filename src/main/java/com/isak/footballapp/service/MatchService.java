package com.isak.footballapp.service;

import com.isak.footballapp.entity.Match;
import com.isak.footballapp.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository){
        this.matchRepository = matchRepository;
    }

    public Match save(Match match){
        return matchRepository.save(match);
    }

    public List<Match> findAll(){
        return matchRepository.findAll();
    }

    public Optional<Match> findById(Long id){
        return matchRepository.findById(id);
    }

    public void deleteById(Long id){
        matchRepository.deleteById(id);
    }
}