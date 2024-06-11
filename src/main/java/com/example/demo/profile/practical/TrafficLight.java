package com.example.demo.profile.practical;

import java.util.logging.Logger;

public class TrafficLight {
	
	private final static Logger log = Logger.getLogger(TrafficLight.class.getName());

	private static String color;
	private static String duration;
	
	public static String getColor() {
		return color;
	}

	public static void setColor(String color) {
		TrafficLight.color = color;
	}

	public static String getDuration() {
		return duration;
	}

	public static void setDuration(String duration) {
		TrafficLight.duration = duration;
	}

	public static void main(String[] args) {
		/*
            2.Write a Java program to create class called "TrafficLight" with 
            attributes for color and duration,  and check 
            for red or green and methods to change the color
		*/
		changeColor(color);
		
	}

	private static void changeColor(String color) {
		
		if(color.equals("red")) {
			log.info("Colour Red found!!");
			color="green";
		} else {
			log.info("Colour Green found!!");
			color="red";
		}
	}
}
