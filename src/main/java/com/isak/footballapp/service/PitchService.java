package com.isak.footballapp.service;

import com.isak.footballapp.entity.Pitch;
import com.isak.footballapp.repository.PitchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PitchService {

    private final PitchRepository pitchRepository;

    public PitchService(PitchRepository pitchRepository){
        this.pitchRepository = pitchRepository;
    }
    //Gamle metoder
    /* public Pitch save(Pitch pitch){
        return pitchRepository.save(pitch);
    }

    public List<Pitch> findAll(){
        return pitchRepository.findAll();
    }

    public Optional<Pitch> findById(Long id){
        return pitchRepository.findById(id);
    } 
        
     public void deleteById(Long id){
        pitchRepository.deleteById(id);
    }
    
    */
   
    //App spesifikke metoder: registerPitch(), getPitchById(), getAllPitches(), getPitchByName(), updatePitch(), deletePitch()

    //registerPitch()
    public Pitch registerPitch(Pitch pitch){
        //tenker først se om pitch allerede eksistere ved å bruke optional?
        Optional<Pitch> existingPitch = pitchRepository.getPitchByPitchName(pitch.getPitchName()); 
        if(existingPitch.isPresent()) {
            throw new IllegalArgumentException("Pitch is already registred");
        }
        //hvis ikke if kjøres så betyr det at banen ikke er funnet basert på id, så da registreres det.
        return pitchRepository.save(pitch);
    }

    //getPitchById
    public Pitch findPitchById(Long id){
        Optional <Pitch> existingPitch = pitchRepository.findById(id);
        if(!existingPitch.isPresent()){
            throw new IllegalArgumentException("Pitch does not exist");
        }

        return existingPitch.get();
    }

    //getAllPitches()
    public List <Pitch> findAllPitches(){
        return pitchRepository.findAll();
    }

    //getPitchByName()
    public Pitch findPitchByName(String pitchName){
        Optional <Pitch> existingPitch = pitchRepository.getPitchByPitchName(pitchName);
        if(!existingPitch.isPresent()){
            throw new IllegalArgumentException("Pitch does not exist");
        }
        return existingPitch.get();
    }

    //deletePitch()
    public void deletePitch(Long id){
        Optional <Pitch> existingPitch = pitchRepository.findById(id);
        if(existingPitch.isEmpty()){
            throw new IllegalArgumentException("Pitch is not found");
        }
        pitchRepository.deleteById(id);;
        System.out.println(existingPitch.get().getPitchName() + " Is deleted");
    }

     //updatePitch()
     public Pitch updatePitch(Long id, Pitch pitch){
        Optional <Pitch> existingPitch = pitchRepository.findById(id);
        if(existingPitch.isEmpty()){
            throw new IllegalArgumentException("Pitch does not exist");
        }
        Pitch updatedPitch = existingPitch.get();
        updatedPitch.setPitchName(pitch.getPitchName());
        updatedPitch.setDistrict(pitch.getDistrict());
        updatedPitch.setLatitude(pitch.getLatitude());
        updatedPitch.setLongitude(pitch.getLongitude());
        updatedPitch.setSize(pitch.getSize());
        updatedPitch.setPricePerHour(pitch.getPricePerHour());
        updatedPitch.setContactNumber(pitch.getContactNumber());
        pitchRepository.save(updatedPitch);
        return updatedPitch;
    }
}