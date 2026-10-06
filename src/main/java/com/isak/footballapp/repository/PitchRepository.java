package com.isak.footballapp.repository;

import com.isak.footballapp.entity.Pitch;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PitchRepository extends JpaRepository<Pitch, Long> {
    public Optional<Pitch> getPitchByPitchName(String pitchName);
  
}