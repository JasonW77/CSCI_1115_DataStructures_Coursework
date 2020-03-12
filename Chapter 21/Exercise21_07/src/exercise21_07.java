/**
Author: Jason Waters
Date: 3/12/2020
Description: Exercise 21-07 for the CSCI 1115 Class at Southwest Tech
*/

/**(Revise Listing 21.9) Rewrite Listing 21.9 with the map variable as a HashMap. 
 * The program should display the words in ascending order of occurrence counts.
 *(Hint: Create a class named WordOccurrence that implements the Comparable interface. 
 *The class contains two fields, word and count. The compareTo method compares the counts. 
 *For each pair in the hash set in Listing 21.9, create an instance of WordOccurrence and 
 *store it in an array list. Sort the array list using the Collections.sort method. 
 *What would be wrong if you stored the instances of WordOccurrence in a tree set?)

*/

import java.util.*;


public class exercise21_07 {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		// Create a HashMap to hold words as key and count as value
		Map<String, Integer> map = new HashMap<>();

		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}

		// Display key and value for each entry
		map.forEach((k, v) -> System.out.println(k + "\t" + v));

		//Create the array list
		ArrayList<WordOccurrence> list = new ArrayList<>();
		
		//store the stuff in the array
		for (Map.Entry<String, Integer> entry: map.entrySet())
			list.add(new WordOccurrence(entry.getKey(), entry.getValue()));
		
		// Sort the list
		Collections.sort(list);
		Collections.reverse(list);

		// Display the sorted list
		System.out.println(list);
		
	}
}



