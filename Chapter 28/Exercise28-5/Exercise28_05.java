/*
Assignment Author: Jason Waters
Date: 6/9/2020
Exercise: 28-05
Class: CSCI 1115
Discription: 

(Find paths) Add a new method in UnweightedGraph to find a path between two vertices with the following header:

public List<Integer> getPath(int u, int v);
The method returns a List<Integer> that contains all the vertices in a path from u to v in this order. You can use the BFS method to return a tree of best path. From there, you can obtain a shortest path from u to v. If there isn’t a path from u to v, the method returns null.

Download these files to start.

Hint: You can search the SearchTree result of bfs(u) by starting at v and then looking at every parent above until you reach u (end of tree or -1). This is easier than starting at u and going to v because u may have multiple children, but v will only have 1 parent.

*/

import java.util.*;

import java.io.*;

public class Exercise28_05 {
	public static void main(String[] args) throws Exception {
		String[] vertices = { "Seattle", "San Francisco", "Los Angeles", "Denver",
				"Kansas City", "Chicago", "Boston", "New York", "Atlanta", "Miami",
				"Dallas", "Houston" };

		int[][] edges = { { 0, 1 }, { 0, 3 }, { 0, 5 }, { 1, 0 }, { 1, 2 },
				{ 1, 3 }, { 2, 1 }, { 2, 3 }, { 2, 4 }, { 2, 10 }, { 3, 0 }, { 3, 1 },
				{ 3, 2 }, { 3, 4 }, { 3, 5 }, { 4, 2 }, { 4, 3 }, { 4, 5 }, { 4, 7 },
				{ 4, 8 }, { 4, 10 }, { 5, 0 }, { 5, 3 }, { 5, 4 }, { 5, 6 }, { 5, 7 },
				{ 6, 5 }, { 6, 7 }, { 7, 4 }, { 7, 5 }, { 7, 6 }, { 7, 8 }, { 8, 4 },
				{ 8, 7 }, { 8, 9 }, { 8, 10 }, { 8, 11 }, { 9, 8 }, { 9, 11 },
				{ 10, 2 }, { 10, 4 }, { 10, 8 }, { 10, 11 }, { 11, 8 }, { 11, 9 },
				{ 11, 10 } };

		UnweightedGraph<String> graph = new UnweightedGraph<>(
				vertices, edges);
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a starting city: ");
		String startingCity = input.nextLine();

		System.out.print("Enter an ending city: ");
		String endingCity = input.nextLine();

		List<Integer> list = graph.getPath(graph.getIndex(startingCity),
				graph.getIndex(endingCity));

		System.out.print("The path is ");
		for (Integer i : list) {
			System.out.print(graph.getVertex(i) + " ");
		}
	}
}