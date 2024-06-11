package com.example.demo.profile.practical;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MasterCard {

	public static void main(String[] args)  {
		MasterCard card = new MasterCard();
		card.map2Param();
		card.map3Param();
    }
	
	public int map2Param()	{
		// Create a String with no repeated keys 
        Stream<String[]> 
            str = Stream 
                      .of(new String[][] { { "GFG", "GeeksForGeeks" }, 
                                           { "g", "geeks" }, 
                                           { "G", "Geeks" } }); 
        // Convert the String to Map 
        // using toMap() method 
        Map<String, String> 
            map = str.collect( 
                Collectors.toMap(p -> p[0], p -> p[1])); 
  
        // Print the returned Map 
        System.out.println("Map 2 Param:" + map);
        return 0;
	}
	
	public int map3Param()	{
		// Create a String to be converted 
        Stream<String[]> 
            Ss1 = Stream 
                      .of(new String[][] { { "GFG", "GeeksForGeeks" }, 
                                           { "g", "geeks" }, 
                                           { "G", "Geeks" } }); 
  
        // Get Map from String 
        // using toMap() method 
        LinkedHashMap<String, String> 
            map = Ss1 
                       .collect(Collectors 
                                    .toMap( 
                                        p -> p[0], p -> p[1], (s, a) -> s + ", " + a, LinkedHashMap::new)); 
        // Print the Map
        System.out.println("Map 3 Param:" + map);
        return 1;
	}
	
}
