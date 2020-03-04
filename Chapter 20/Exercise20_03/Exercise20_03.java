/*
Author: Jason Waters
Date: 3/4/2020

Description: Exercise 20-03 for the CSCI 1115 Class at Southwest Tech
*/


import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Exercise20_03 {
  public static void main(String[] args) {
	  
	  LinkedList<String[]> list = new LinkedList<>();
	  Collections.addAll(list, stateCapital);
	  
	  Scanner input = new Scanner(System.in);
	  int correctCount = 0;

	  while (list.size() > 0) {
		  Collections.shuffle(list);
		  String[] stCap = list.pollFirst();
		  System.out.print("What is the capital of " + stCap[0] + "? ");
		  String capital = input.nextLine().trim().toLowerCase();
		  if (capital.toLowerCase().equals(stCap[1].toLowerCase())) {
		        System.out.println("Your answer is correct");
		        correctCount++;
		      }
		      else
		        System.out.println("The correct answer should be " + stCap[1]);
		    }

		    System.out.println("The correct count is " + correctCount);
		  }

    private static String[][] stateCapital = {
      {"Alabama", "Montgomery"},
      {"Alaska", "Juneau"},
      {"Arizona", "Phoenix"},
      {"Arkansas", "Little Rock"},
      {"California", "Sacramento"},
      {"Colorado", "Denver"},
      {"Connecticut", "Hartford"},
      {"Delaware", "Dover"},
      {"Florida", "Tallahassee"},
      {"Georgia", "Atlanta"},
      {"Hawaii", "Honolulu"},
      {"Idaho", "Boise"},
      {"Illinois", "Springfield"},
      {"Indiana", "Indianapolis"},
      {"Iowa", "Des Moines"},
      {"Kansas", "Topeka"},
      {"Kentucky", "Frankfort"},
      {"Louisiana", "Baton Rouge"},
      {"Maine", "Augusta"},
      {"Maryland", "Annapolis"},
      {"Massachusettes", "Boston"},
      {"Michigan", "Lansing"},
      {"Minnesota", "Saint Paul"},
      {"Mississippi", "Jackson"},
      {"Missouri", "Jefferson City"},
      {"Montana", "Helena"},
      {"Nebraska", "Lincoln"},
      {"Nevada", "Carson City"},
      {"New Hampshire", "Concord"},
      {"New Jersey", "Trenton"},
      {"New York", "Albany"},
      {"New Mexico", "Santa Fe"},
      {"North Carolina", "Raleigh"},
      {"North Dakota", "Bismarck"},
      {"Ohio", "Columbus"},
      {"Oklahoma", "Oklahoma City"},
      {"Oregon", "Salem"},
      {"Pennsylvania", "Harrisburg"},
      {"Rhode Island", "Providence"},
      {"South Carolina", "Columbia"},
      {"South Dakota", "Pierre"},
      {"Tennessee", "Nashville"},
      {"Texas", "Austin"},
      {"Utah", "Salt Lake City"},
      {"Vermont", "Montpelier"},
      {"Virginia", "Richmond"},
      {"Washington", "Olympia"},
      {"West Virginia", "Charleston"},
      {"Wisconsin", "Madison"},
      {"Wyoming", "Cheyenne"}
    };
}
