package com.isak.footballapp.service;

import com.isak.footballapp.entity.Booking;
import com.isak.footballapp.entity.User;
import com.isak.footballapp.entity.Pitch;
import com.isak.footballapp.repository.BookingRepository;
import com.isak.footballapp.repository.UserRepository;
import com.isak.footballapp.repository.PitchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final PitchRepository pitchRepository;
    //private final vippsConnector vippsConnector; ? så inni konstruktøren og egne metoder?

    public BookingService(BookingRepository bookingRepository, UserRepository userRepository, PitchRepository pitchRepository){
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.pitchRepository = pitchRepository;
    }

    public Booking save(Booking booking){
        return bookingRepository.save(booking);
    }

    public List<Booking> findAll(){
        return bookingRepository.findAll();
    }

    public Optional<Booking> findById(Long id){
        return bookingRepository.findById(id);
    }

    public void deleteById(Long id){
        bookingRepository.deleteById(id);
    }



//appspesifikke metoder: registerBooking(),findBookingById(),findAllBookings(),updateBookingById(),deleteBookingById(),findBookingsByUser(),findBookingsByPitch()

//registerBooking // Sjekk om banen er ledig // Sjekk at brukeren finnes // Sjekk at tidspunktet er gyldig

public Booking registerBooking(Long userId, Booking booking){
    //sjekk at bruker finnes
    Optional<User> existingUser = userRepository.findById(userId);
    if(existingUser.isEmpty()){
        throw new IllegalArgumentException("User does not exist");
    }
    //sjekk om banen finnes
    Optional<Pitch> existingPitch = pitchRepository.findById(booking.getPitch().getPitchId());
    if (existingPitch.isEmpty()) {
        throw new IllegalArgumentException("Pitch does not exist");
    }
    //Pitch pitch = existingPitch.get();
    //Hent alle bookinger på banen
    List<Booking> existingBookings = bookingRepository.findAllByPitch(booking.getPitch());
    //Sjekk om tidspunktet overlapper
    for (Booking existingBooking : existingBookings){

        if(booking.getStartTime().isBefore(existingBooking.getEndTime()) && booking.getEndTime().isAfter(existingBooking.getStartTime())){
            throw new IllegalArgumentException("Pitch is already booked during this time.");
        }
    }
    return bookingRepository.save(booking);
}
//findBookingById()
public Booking findBookingById(Long id){
    Optional<Booking> existingBooking = bookingRepository.findById(id);
    if(existingBooking.isEmpty()){
        throw new IllegalArgumentException("Booking does not exist");
    }
    
    return existingBooking.get();
}
//findAllBookingsByPitch()

//findAllByPitch  finner alle bookinger for en bestemt bane
public List <Booking> findAllByPitch(Pitch pitch){
    //sjekk om pitch finnes
    Optional <Pitch> existingPitch = pitchRepository.getPitchByPitchName(pitch.getPitchName());
    if(existingPitch.isEmpty()){
        throw new IllegalArgumentException("Pitch does not exist");
    }
    return bookingRepository.findAllByPitch(existingPitch.get());
}
//deleteBookingById()
public void deleteBookingById(Booking booking){
    //sjekk om booking finnes
    Optional<Booking> existingBooking = bookingRepository.findById(booking.getBookingId());
    if(existingBooking.isEmpty()){
        throw new IllegalArgumentException("Booking does not exist");
    }

    bookingRepository.delete((existingBooking.get()));

}

}