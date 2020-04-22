/**
Author: Jason Waters
Date: 4/21/2020
Description: Exercise 22-01 for the CSCI 1115 Class at Southwest Tech
*/
	
/**
(Maximum consecutive increasingly ordered substring ) Write a program that prompts the user to enter a string and displays the maximum consecutive increasingly ordered substring. Analyze the time complexity of your program.
*/

/**
Analysis:
1 single loop x3 simple statements: 3
1 single loop x1 simple statement: 1
	T(n) = 0(n) linear time
*/
	
import java.util.*;

public class Exercise_22_01 {
	public static void main(String[] args) {
		
		// Create Scanner and linked lists
		Scanner input = new Scanner(System.in);
		
		LinkedList<Character> max = new LinkedList<>();
		LinkedList<Character> list = new LinkedList<>();

		// Prompt the user to enter a string to search through
		System.out.print("Enter a string: ");
		String string = input.nextLine(); 
		
		// Find the maximum consecutive increasingly ordered substring
		for (int i = 0; i < string.length(); i++) { 		
			if (list.size() > 1 && string.charAt(i) <= list.getLast() && 
				list.contains(string.charAt(i))) {
				list.clear(); 
			}

			list.add(string.charAt(i)); 

			if (list.size() > max.size()) { 
				max.clear();
				max.addAll(list);
			}
		}
		
		// Display the results
		for (Character ch: max) { 
			System.out.print(ch); 
		}
		System.out.println();
	}


}