package com.example.demo.profile.practical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class Java8BasicPrograms {
	final static Logger log = Logger.getLogger(Java8BasicPrograms.class.getName());
	
	public static void main(String[] args) {
		
		// 1 
		findMaxMinInMixedList(List.of(10,20,10.1,20.5,0,03,-2,-20,34,62,10d,20.00f,20.00,-10));
		
		// 2
		List<Player> playerList = List.of(
				new Player(67, "Rose1", 2),
				new Player(59, "John",  5),
				new Player(59, "Rose2", 1),
				new Player(61, "Aeda1", 1),
				new Player(67, "Aeda2", 1)
			);
		comparator(playerList);
		
		// 3
		stringReverse();
		
		// 4
		onlyEven();
		
		// 5
		seriesQue();
	}
	                                                                                                                                                                      
	public static void findMaxMinInMixedList(List<Number> mixedList)	{
		log.info("List Data: " + mixedList);
		
		List<Double> doubleList = mixedList.stream().flatMap(n -> {
			return Stream.of(n.doubleValue());
		}).sorted().toList();
		
		log.info("Max - " + doubleList.stream().max(Comparator.naturalOrder()).get());
		log.info("Min - " + doubleList.stream().min(Comparator.naturalOrder()).get());
		
		List<Double> naturalNumberList = mixedList.stream()
				.flatMap(n -> {return Stream.of(n.doubleValue());})
				.filter(n -> n>=1)
				.sorted()
				.toList();
		log.info("Natural Number List - " + naturalNumberList); 
		
	}
	
	private static void comparator(List<Player> playerList) {
		List<Player> sortedPlayerList = new ArrayList<>(playerList);

		sortedPlayerList.sort(Comparator.comparingInt(Player::getGrade));
		log.info("List sorted by Grade - " + sortedPlayerList);
		
		Collections.sort(sortedPlayerList, (p1,p2) -> p1.getAge()-p2.getAge());
		log.info("List sorted by Age - " + sortedPlayerList);
		
		Collections.sort(sortedPlayerList, Comparator.comparing(Player::getName));
		log.info("List sorted by Name - " + sortedPlayerList);
		
		sortedPlayerList.sort(Comparator
				.comparingInt(Player::getAge)
				.thenComparing(Player::getName)
				.thenComparingDouble(Player::getGrade)
				);
		log.info("List sorted by Multi Paramaters - " + sortedPlayerList);
		
		List<String> custmIdList = new ArrayList<String>(List.of("E1A2DODBLEP9","E1E2DOUBLEP1","E9E2ZOZBLEP0"));
		Collections.sort(custmIdList, (id1,id2) -> {
			if(true) {
				return 0;
			} else if(false){
				return -1;
			}
			return 1;
		});
	}
	
	public static void stringReverse() {

		// I/P Simple String
		// O/P elpmiS gnirtS
		
		String s1 = "Simple String";
	
		System.out.printf("Main String - '%s'", s1);
		System.out.println();
		System.out.printf("Reverse String - '%s'" , new StringBuilder(s1).reverse());
		System.out.println();
		System.out.printf("Reverse String - '%s'", StringUtils.reverse(s1));
	}
	
	public static void onlyEven() {
		System.out.println();
		int[] arr = {1,2,3,4,5,6,7,8,9,0,4,5,6,7,1};
		System.out.printf("Original String-'%s'",Arrays.toString(arr));
		System.out.println();
		int[] evenArr =  Arrays.stream(arr).skip(0).filter(i->i!=0&&i%2==0).toArray();
		System.out.printf("Filtered String-'%s'",Arrays.toString(evenArr));
		
	}

	private static void seriesQue() {
		/*
		Given an integer array nums, find the 
		subarray with the largest sum, and return its sum.
		 
		Input: [-3, -4, 5, -1, 2, -4, 6, -1] 
		Output: 8
		Explanation: Subarray [5, -1, 2, -4, 6] is the max sum contiguous subarray with sum 8.

		Input: [-2, 3, -1, 2]
		Output: 4
		Explanation: Subarray [3, -1, 2] is the max sum contiguous subarray with sum 4.
		*/

		int[] arr = {-3, -4, 5, -1, 2, -4, 6, -1}; //-ve 13  +ve 13
		
		//int sum = Arrays.stream(arr).sum();
		
		int maxSum = 0;
		for(int i=0;i<=arr.length;i++)	{
			int sum = 0;
			for(int j=arr.length-i;j>=1;j--)	{
				sum = sum + arr[j];
				if(sum > maxSum){
					maxSum = sum;
				}
			}
			if(sum>=maxSum) {
				log.info(Arrays.toString(arr));
			}
		}
		
		
		//log.info("Sum - " + sum);
		
	}
	
	
	
}