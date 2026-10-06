package com.isak.footballapp.repository;
import java.util.List;
//import java.time.LocalDateTime;
//import java.util.Optional;
import com.isak.footballapp.entity.Pitch;


import com.isak.footballapp.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    //finne booking basert på Pitch, dato, tidspunkt, 
    public List <Booking> findAllByPitch(Pitch pitch);
    //public List<Booking> findByPitch(Pitch pitch);
    //Optional<Booking> findBookingByDate(LocalDateTime date);
    //Optional<Booking> findBookingByTime(LocalDateTime time);

}