/*
Assignment Author: Jason Waters
Date: 6/11/2020
Exercise: 28-07
Class: CSCI 1115
Discription: 

(Find a cycle) Add a new method in UnweightedGraph to find a cycle in the graph with the following header:

public List<Integer> getACycle()
The method returns a List that contains all the vertices in a cycle starting from u. If the graph doesn’t have any cycles, the method returns null.

Download these files to start.

The output should be:

Find a cycle [8, 10, 11]
Find a cycle [3, 1, 0]
or

Find a cycle [1, 2, 4, 3]
Find a cycle [0, 3, 1]

This article should help explain cycles and the approach to solve.

Psuedocode: Input: G = (V, E) Output: A list that consists of the vertices in a cycle

public List<Integer> getACycle() { 
	create a list with all the vertices
	create a boolean array to determine if a vertex has been visited (false by default)
	create an int array to determine parent of vertex (-1 by default)
	while (there are unvisited vertices) { // check list size for this 
		pick one, say v; 
		create stack;
		push v to the stack; 
		mark v visited; 
		remove v from list with all vertices;
		while (the stack is not empty) { 
			peek a vertex from the stack, say x; 
			if (x has no neighbors) {
				pop a vertex from the stack;
			}
			else {
				loop through all neighbors of x with loop variable i {
				   Let e be the edge between x and the neighbor; 
				   if (ending vertex of e (e.v) is not visited) { 
					   parent[e.v] = x; 
					   push e.v onto the stack; 
					   mark e.v visited; 
					   remove e.v from list with all vertices;
					   remove loop variable i from x's neighbor list;
					   break;
				   } 
				   else if (e.v is not x's parent) {
					   create an Integer ArrayList;
					   add e.v to list;
					   while (x != e.v and x != -1) {
						   add x to list;
						   x is parent of x;
					   }
					   return list;
				   }
				   else { 
					   remove loop variable i from list with neighbors;
				   }
			   }   
		   } 
	   }
	}
	return an empty list;
}
*/

public class Exercise28_07 {
	public static void main(String[] args) {
		String[] vertices = { "Seattle", "San Francisco", "Los Angeles",
				"Denver", "Kansas City", "Chicago", "Boston", "New York",
				"Atlanta", "Miami", "Dallas", "Houston" };

		int[][] edges = { { 0, 1 }, { 1, 0 }, { 1, 2 }, { 1, 3 }, { 2, 1 },
				{ 2, 3 }, { 2, 4 }, { 2, 10 }, { 3, 1 }, { 3, 2 }, { 3, 4 },
				{ 3, 5 }, { 4, 2 }, { 4, 3 }, { 4, 5 }, { 4, 7 }, { 4, 8 },
				{ 4, 10 }, { 5, 3 }, { 5, 4 }, { 5, 6 }, { 5, 7 }, { 6, 5 },
				{ 6, 7 }, { 7, 4 }, { 7, 5 }, { 7, 6 }, { 7, 8 }, { 8, 4 },
				{ 8, 7 }, { 8, 9 }, { 8, 10 }, { 8, 11 }, { 9, 8 }, { 9, 11 },
				{ 10, 2 }, { 10, 4 }, { 10, 8 }, { 10, 11 }, { 11, 8 },
				{ 11, 9 }, { 11, 10 } };

		UnweightedGraph<String> graph = new UnweightedGraph<>(
				vertices, edges);

		System.out.println("Find a cycle " + graph.getACycle());

		Integer[] vertices1 = { 0, 1, 2, 3 };

		int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 0 }, { 1, 3 },
				{ 2, 0 }, { 3, 0 } };

		UnweightedGraph<Integer> graph1 = new UnweightedGraph<>(
				vertices1, edges1);

		System.out.println("Find a cycle " + graph1.getACycle());
	}
}