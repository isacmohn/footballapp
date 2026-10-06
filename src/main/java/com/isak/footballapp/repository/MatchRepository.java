package com.isak.footballapp.repository;

import com.isak.footballapp.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {

}