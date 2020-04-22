/**
Author: Jason Waters
Date: 4/21/2020
Description: Exercise 22-03 for the CSCI 1115 Class at Southwest Tech
*/

/**
(Pattern matching ) Write a program that prompts the user to enter two strings and tests whether the second string is a substring of the first string. Suppose the neighboring characters in the string are distinct.  (Don’t use the indexOf method in the String class.) 

	Analyze the time complexity of your algorithm. 
	Your algorithm needs to be at least O(n) time.
*/

/**
Analysis:
1 single loop
4 simple statements
T(n) = (c+c+c+c) * n
T(n) = 4c * n
T(n) = 0(n) linear time

*/

import java.util.*;

public class Exercise_22_03 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter the first string
		System.out.print("Enter a string s1: ");
		String s1 = input.nextLine();
		
		//Prompt the user to enter the second string
		System.out.print("Enter a string s2: ");
		String s2 = input.nextLine();

		int index = -1; 
		int count = 0;  

		// test whether the second string is a substring of the first string
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(0) && count == 0) {
				index = i;
				count++;
			}
			else if (s1.charAt(i) == s2.charAt(count)) {
				count++;
			}
			else {
				count = 0;
				index = -1;
			}

			if (count == s2.length())
				break;
		}

		// Display the results
		if (index > 1)
			System.out.println("matched at index " + index);
		else
			System.out.println("match not found");
	}


}