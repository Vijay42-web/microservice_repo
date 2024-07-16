package com.example.rating.servicesimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rating.entities.Rating;
import com.example.rating.reposiotory.RatingRepository;
import com.example.rating.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService 
{
	@Autowired
	RatingRepository ratingrepo;

	@Override
	public Rating createRating(Rating rating) {
		
		String ratingId=UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		
		return ratingrepo.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		
		return ratingrepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) 
	{
		
		return ratingrepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		
		return ratingrepo.findByHotelId(hotelId);
	}

}
