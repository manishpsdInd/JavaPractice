package com.example.demo.profile.practical;

import java.io.IOException;

public class Tester {
	
	public static void main(String[] args) {
		
		double d = 10.0 / -0;
		if(d == Double.POSITIVE_INFINITY)	{
			System.out.println("Positive infinity");
		}	else	{	
			System.out.println("Negative infinity");
		}
		
		try {
			new AirJet();
		} catch(IOException e)	{
			System.out.println("IOException in thrown in Tester");
		}
	}
	
	static class AirJet extends AirPlane {
		public AirJet() throws IOException	{
			//super();
			System.out.println("AirJet");
			/*try {
				super();
			} catch(IOException e) {
				System.out.println("IOException in thrown in AirJet");
			}*/
		}
	}
	
	static class AirPlane 	{
		public AirPlane() throws IOException	{
			System.out.println("AirPlane");
			throw new IOException(); 
		}
	}
}
