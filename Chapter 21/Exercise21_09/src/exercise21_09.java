/**
Author: Jason Waters
Date: 3/12/2020
Description: Exercise 21-09 for the CSCI 1115 Class at Southwest Tech
*/

/**(Guess the capitals using maps) 
 * Rewrite Programming Exercise 8.37 to store pairs of each state and its capital in a map. 
 * Your program should prompt the user to enter a state 
 * and should display the capital for the state.
 */

import java.util.*;

public class exercise21_09 {
	
	public static void main(String[] args) {
		
	    Map<String, String> stateCapital = new LinkedHashMap<>();
	    stateCapital.put("alabama", "Montgomery");
	    stateCapital.put("alaska", "Juneau");
	    stateCapital.put("arizona", "Phoenix");
	    stateCapital.put("arkansas", "Little Rock");
	    stateCapital.put("california", "Sacramento");
            stateCapital.put("colorado", "Denver");
	    stateCapital.put("connecticut", "Hartford");
	    stateCapital.put("delaware", "Dover");
	    stateCapital.put("florida", "Tallahassee");
	    stateCapital.put("georgia", "Atlanta");
  	    stateCapital.put("hawaii", "Honolulu");
	    stateCapital.put("idaho", "Boise");
	    stateCapital.put("illinois", "Springfield");
	    stateCapital.put("indiana", "Indianapolis");
	    stateCapital.put("iowa", "Des Moines");
  	    stateCapital.put("kansas", "Topeka");
	    stateCapital.put("kentucky", "Frankfort");
	    stateCapital.put("louisiana", "Baton Rouge");
	    stateCapital.put("maine", "Augusta");
	    stateCapital.put("maryland", "Annapolis");
	    stateCapital.put("massachusettes", "Boston");
	    stateCapital.put("michigan", "Lansing");
	    stateCapital.put("minnesota", "Saint Paul");
	    stateCapital.put("mississippi", "Jackson");
	    stateCapital.put("missouri", "Jefferson City");
	    stateCapital.put("montana", "Helena");
	    stateCapital.put("nebraska", "Lincoln");
	    stateCapital.put("nevada", "Carson City");
	    stateCapital.put("new hampshire", "Concord");
	    stateCapital.put("new jersey", "Trenton");
	    stateCapital.put("new york", "Albany");
	    stateCapital.put("new mexico", "Santa Fe");
	    stateCapital.put("north carolina", "Raleigh");
	    stateCapital.put("north dakota", "Bismarck");
	    stateCapital.put("ohio", "Columbus");
	    stateCapital.put("oklahoma", "Oklahoma City");
	    stateCapital.put("oregon", "Salem");
	    stateCapital.put("pennsylvania", "Harrisburg");
	    stateCapital.put("rhode island", "Providence");
	    stateCapital.put("south carolina", "Columbia");
	    stateCapital.put("south dakota", "Pierre");
	    stateCapital.put("tennessee", "Nashville");
	    stateCapital.put("texas", "Austin");
	    stateCapital.put("utah", "Salt Lake City");
	    stateCapital.put("vermont", "Montpelier");
	    stateCapital.put("virginia", "Richmond");
	    stateCapital.put("washington", "Olympia");
	    stateCapital.put("west virginia", "Charleston");
	    stateCapital.put("wisconsin", "Madison");
	    stateCapital.put("wyoming", "Cheyenne");
	   

	   Scanner input = new Scanner(System.in);
	    
	   for (int i = 0; i <= stateCapital.size(); i++) {
		   	System.out.print("Enter a State Name: ");
	   		String capital = input.nextLine().trim().toLowerCase();
	   		System.out.println("The Capital for " + capital + " is: " + stateCapital.get(capital));
	   }
		  //System.out.println("Display Entries in hashMap stateCapital");
		  //System.out.println(stateCapital + "/n");
		  
		  }
	
	}
