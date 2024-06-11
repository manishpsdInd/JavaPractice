package com.example.demo.profile.practical;

public class DataNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DataNotFound()	{
		
	}
	
	public DataNotFound(String message)	{
		super(message);
	}
	
	public DataNotFound(String message, String errCode)	{
		super(message);
	}
	
	
}
