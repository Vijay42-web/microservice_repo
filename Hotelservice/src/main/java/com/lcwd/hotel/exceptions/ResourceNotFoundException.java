package com.lcwd.hotel.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException()
	{
		super("Resource not Found on Server!!");
	}
	public ResourceNotFoundException(String s)
	{
		super(s);
	}

}
