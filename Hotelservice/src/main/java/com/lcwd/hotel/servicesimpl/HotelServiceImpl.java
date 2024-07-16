package com.lcwd.hotel.servicesimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.repository.HotelRepository;
import com.lcwd.hotel.services.HotelService;
import com.lcwd.hotel.exceptions.ResourceNotFoundException;

@Service
public class HotelServiceImpl implements HotelService
{
	@Autowired
	HotelRepository hotelrepo;

	@Override
	public Hotel create(Hotel hotel) {
		
		 String hotelId =UUID.randomUUID().toString();
		 hotel.setId(hotelId);
      
		return hotelrepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		
		return hotelrepo.findAll();
	}

	@Override
	public Hotel get(String id) {
		
		return hotelrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not Found on Server with this id !! :" +id));
	}
	

}
