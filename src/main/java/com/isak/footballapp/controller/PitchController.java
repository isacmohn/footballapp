package com.isak.footballapp.controller;

import com.isak.footballapp.entity.Pitch;
import com.isak.footballapp.service.PitchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pitches")
public class PitchController {

    private final PitchService pitchService;

    public PitchController(PitchService pitchService) {
        this.pitchService = pitchService;
    }

    // Registrerer en ny bane
    @PostMapping("/register")
    public Pitch registerPitch(@RequestBody Pitch pitch) {
        return pitchService.registerPitch(pitch);
    }

    // Henter én bane med ID
    @GetMapping("/{id}")
    public Pitch findPitchById(@PathVariable Long id) {
        return pitchService.findPitchById(id);
    }

    // Henter alle baner
    @GetMapping
    public List<Pitch> findAllPitches() {
        return pitchService.findAllPitches();
    }

    // Henter en bane med navn
    @GetMapping("/name/{pitchName}")
    public Pitch findPitchByName(@PathVariable String pitchName) {
        return pitchService.findPitchByName(pitchName);
    }

    // Oppdaterer en bane med ID
    @PutMapping("/{id}")
    public Pitch updatePitch(
            @PathVariable Long id,
            @RequestBody Pitch pitch) {

        return pitchService.updatePitch(id, pitch);
    }

    // Sletter en bane med ID
    @DeleteMapping("/{id}")
    public void deletePitch(@PathVariable Long id) {
        pitchService.deletePitch(id);
    }
}