package com.example.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rating.entities.Rating;
import com.example.rating.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController 
{
	@Autowired
	RatingService ratingservice;
	
	@PostMapping
	public ResponseEntity<Rating>create(@RequestBody Rating rating)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingservice.createRating(rating));
	}
	@GetMapping
	public ResponseEntity<List<Rating>>getRatings()
	{
		return ResponseEntity.ok(ratingservice.getAllRatings());
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>>getRatingsByUserId(@PathVariable String userId)
	{
		return ResponseEntity.ok(ratingservice.getRatingByUserId(userId));
	}
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>>getRatingsByHotelId(@PathVariable String hotelId)
	{
		return ResponseEntity.ok(ratingservice.getRatingByHotelId(hotelId));
	}
	

}
