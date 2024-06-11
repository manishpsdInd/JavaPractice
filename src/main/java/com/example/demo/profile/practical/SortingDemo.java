package com.example.demo.profile.practical;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortingDemo {

	public static void main(String[] args) {

		/* Sort Array Elements By Frequency
		 * I/P int[] {7, 1, 3, 4, 7, 1, 7, 1, 4, 5, 1, 9, 3}
		 * O/P [1, 1, 1, 1, 7, 7, 7, 3, 3, 4, 4, 5, 9]
		 */
		
		int[] array = { 7, 1, 3, 4, 7, 1, 7, 1, 4, 5, 1, 9, 3 };
		System.out.println("Input:: I/P [7, 1, 3, 4, 7, 1, 7, 1, 4, 5, 1, 9, 3]");
		System.out.println("Expected:: O/P [1, 1, 1, 1, 7, 7, 7, 3, 3, 4, 4, 5, 9]");

		List<Integer> list = List.of(7, 1, 3, 4, 7, 1, 7, 1, 4, 5, 1, 9, 3);
		//System.out.println("newList " + list.stream().sorted().toList());
		System.out.println("newList " + list.stream().sorted().collect(Collectors.toList()));
		// [1, 1, 1, 1, 3, 3, 4, 4, 5, 7, 7, 7, 9]

		int[] sortedByFreq = 
				Arrays.stream(array).boxed()
				.collect(
						Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.flatMap(entry -> Collections.nCopies(entry.getValue().intValue(), entry.getKey()).stream())
				.mapToInt(Integer::intValue).toArray();
		System.out.println("sortedByFreq " + Arrays.toString(sortedByFreq));

		Map<Integer, Long> frequencyMap = new HashMap<>();
		for (int num : array) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0L) + 1);
		}
		System.out.println(frequencyMap);

	}

}