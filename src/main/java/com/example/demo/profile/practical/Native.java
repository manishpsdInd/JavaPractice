package com.example.demo.profile.practical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Native {

	/*
	int[] i = (1,0,2,-2);
	int sum=2;
	
	I/P -> 1,0,-2 < 2
	 */
	
	public static void main(String[] args) {

		
		List<Integer> integerList = Arrays.asList(1,2,3,1,2,7,9);
		//{1=1, 2=1, 3=1, 7=1, 9=1}
		
		Map<Integer,Integer> checkDuplicates = new HashMap<>();
		
		for(int i : integerList)	{
			checkDuplicates.put(i, checkDuplicates.getOrDefault(i, 0)+1);
		}
		
		System.out.println(integerList.stream().count());
		System.out.println(checkDuplicates.toString());
		
	int[] arr = {1,0,2,-2};
	int sum=2;
	int temp=0;
	List<Integer> tripple = new ArrayList<Integer>();
	
	//for()	{
		for(int i=0;i<=arr.length-1;i++)	{
		
			temp = temp + arr[i];
			tripple.add(arr[i]);
			
			if(temp < sum && tripple.size() >=3)	{
				break;
			}
			System.out.println(tripple.toString());
		}
		
	//}	
	}
	
}
