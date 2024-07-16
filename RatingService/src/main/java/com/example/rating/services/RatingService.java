package com.example.rating.services;

import java.util.List;

import com.example.rating.entities.Rating;

public interface RatingService 
{
	
	Rating createRating(Rating rating);
	
	List<Rating>getAllRatings();
	
	List<Rating>getRatingByUserId(String userId);
	
	List<Rating>getRatingByHotelId(String hotelId);
	

}
