package com.isak.footballapp.repository;

import com.isak.footballapp.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

}