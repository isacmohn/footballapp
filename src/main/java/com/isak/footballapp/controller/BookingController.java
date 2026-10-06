package com.isak.footballapp.controller;

import com.isak.footballapp.entity.Booking;
import com.isak.footballapp.entity.Pitch;
import com.isak.footballapp.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    // Registrerer en booking
    @PostMapping("/register/{userId}")
    public Booking registerBooking(
            @PathVariable Long userId,
            @RequestBody Booking booking){

        return bookingService.registerBooking(userId, booking);
    }

    // Finner en booking med ID
    @GetMapping("/{id}")
    public Booking findBookingById(@PathVariable Long id){
        return bookingService.findBookingById(id);
    }

    // Henter alle bookinger
    @GetMapping
    public List<Booking> findAll(){
        return bookingService.findAll();
    }

    // Henter alle bookinger for en bane
    @PostMapping("/pitch")
    public List<Booking> findAllByPitch(@RequestBody Pitch pitch){
        return bookingService.findAllByPitch(pitch);
    }

    // Sletter en booking
    @DeleteMapping
    public void deleteBookingById(@RequestBody Booking booking){
        bookingService.deleteBookingById(booking);
    }

}