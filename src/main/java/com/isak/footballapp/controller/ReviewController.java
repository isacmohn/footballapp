package com.isak.footballapp.controller;

import com.isak.footballapp.entity.Review;
import com.isak.footballapp.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @PostMapping
    public Review save(@RequestBody Review review){
        return reviewService.save(review);
    }

    @GetMapping
    public List<Review> findAll(){
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Review> findById(@PathVariable Long id){
        return reviewService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        reviewService.deleteById(id);
    }
}