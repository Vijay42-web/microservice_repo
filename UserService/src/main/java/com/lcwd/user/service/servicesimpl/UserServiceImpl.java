package com.lcwd.user.service.servicesimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.logging.*;
import com.lcwd.user.service.entity.Rating;
import com.lcwd.user.service.entity.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.repository.UserRepository;
import com.lcwd.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	UserRepository userrepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public User saveUser(User user) 
	{
		String randomUserId=UUID.randomUUID().toString();
		user.setUserId(randomUserId);
			return userrepo.save(user);
	}

	@Override
	public List<User> getAllUser() 
	{
		
		return userrepo.findAll();
	}

	@Override
	public User getUser(String userId) {
		
		User user= userrepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not Found on Server with this id !! :" +userId));
		
		ArrayList<Rating> ratingsOfUser = restTemplate.getForObject("http://localhost:7676/ratings/users/fe96d49d-691a-47ab-91d0-8fd050d8783f", ArrayList.class);
		logger.info("{}",ratingsOfUser);
		
		user.setRatings(ratingsOfUser);
		
		user.setName(userId);
		return user;
		
	}

}
