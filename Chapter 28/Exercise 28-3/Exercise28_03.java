/*
Assignment Author: Jason Waters
Date: 6/4/2020
Exercise: 27-11
Class: CSCI 1115
Discription: 

(Implement DFS using a stack) The depth-first search algorithm described in Listing 28.8 uses recursion. Write a new method that performs a depth-first search without using recursion, called dfsNonRecurs().
The UnweightedGraph file contains the algorithm for dfs without using recursion. 
Note: When using the List neighbors, be aware that it is a List within a List. In other words, to see how many neighbors vertex x has, you would use neighbors.get(x). Then to actually grab the first neighbor vertex, you would use neighbors.get(x).get(0).
public SearchTree dfsNonRecurs(int v) {
    int[] parent = new int[vertices.size()];
    for (int i = 0; i < parent.length; i++)
       parent[i] = -1;
    boolean[] isVisited = new boolean[vertices.size()];
    List<Integer> searchOrder = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
 
    push v to the stack
    add v to search order
    mark v visited

    while (the stack is not empty) {
        peek a vertex from the stack, call x

        if (neighbors list for x equals size 0) {
           pop a vertex from the stack
        }
        else {
            for (int i = size of vertices in x's neighbor list and count towards 0) {
                grab Edge at index i, call e
                remove ending vertex from x's neighbor list

                if (ending vertex of e is not visited) {
                    mark parent of ending vertex as x
                    push ending vertex onto stack
                    mark ending vertex as visited
                    add ending vertex to search order
                    break;
                }
            }
        }
    return new SearchTree(v, parent, searchOrder);
}

If your for loop counts from size to 0, the output should be:

12 vertices are searched in this DFS order:
Chicago New York Atlanta Houston Dallas Kansas City Denver Los Angeles San Francisco Seattle Miami Boston 

parent of Seattle is San Francisco
parent of San Francisco is Los Angeles
parent of Los Angeles is Denver
parent of Denver is Kansas City
parent of Kansas City is Dallas
parent of Boston is New York
parent of New York is Chicago
parent of Atlanta is New York
parent of Miami is Houston
parent of Dallas is Houston
parent of Houston is Atlanta
If your for loop counts from 0 to size, the output should be:

12 vertices are searched in this DFS order:
Chicago Seattle San Francisco Denver Los Angeles Kansas City Atlanta Miami Houston Dallas New York Boston 

parent of Seattle is Chicago
parent of San Francisco is Seattle
parent of Los Angeles is Denver
parent of Denver is San Francisco
parent of Kansas City is Los Angeles
parent of Boston is New York
parent of New York is Atlanta
parent of Atlanta is Kansas City
parent of Miami is Atlanta
parent of Dallas is Houston
parent of Houston is Miami
*/


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Exercise28_03 {
  public static void main(String[] args) {
    String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
      "Denver", "Kansas City", "Chicago", "Boston", "New York",
      "Atlanta", "Miami", "Dallas", "Houston"};

    int[][] edges = {
      {0, 1}, {0, 3}, {0, 5},
      {1, 0}, {1, 2}, {1, 3},
      {2, 1}, {2, 3}, {2, 4}, {2, 10},
      {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
      {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
      {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
      {6, 5}, {6, 7},
      {7, 4}, {7, 5}, {7, 6}, {7, 8},
      {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
      {9, 8}, {9, 11},
      {10, 2}, {10, 4}, {10, 8}, {10, 11},
      {11, 8}, {11, 9}, {11, 10}
    };

    UnweightedGraph<String> graph = new UnweightedGraph<>(vertices, edges);
    UnweightedGraph<String>.SearchTree dfs = graph.dfsNonRecurs(graph.getIndex("Chicago")); 

    java.util.List<Integer> searchOrders = dfs.getSearchOrder();
    
    System.out.println(dfs.getNumberOfVerticesFound() + " vertices are searched in this DFS order:");
    for (int i = 0; i < searchOrders.size(); i++) {
      System.out.print(graph.getVertex(searchOrders.get(i)) + " ");
    }
    System.out.println('\n');

    for (int i = 0; i < searchOrders.size(); i++)
      if (dfs.getParent(i) != -1)
        System.out.println("parent of " + graph.getVertex(i) + " is " + graph.getVertex(dfs.getParent(i)));
  }
}
