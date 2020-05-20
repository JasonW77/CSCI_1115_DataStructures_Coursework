/*
Assignment Author: Jason Waters
Date: 5/20/2020
Exercise: 24-03
Class: CSCI 1115
Discription: 
(Implement a doubly linked list) The MyLinkedList class used in Listing 24.6 is a one-way directional linked list that enables one-way traversal of the list. A doubly linked list enables two-way traversal. To do this, the Node class needs to be modified to add the new data field name previous to refer to the previous node in the list, as follows:

public class Node<E> { 
	E element;
	Node<E> next; 
	Node<E> previous; 

	public Node(E e) { 
		element = e; 
	}
} 
Implement a new class named TwoWayLinkedList that uses a doubly linked list to store elements. We have built a majority of the Exercise24_3 class for you, including Node and the iterators. Make edits to the TwoWayLinkedList class where told in the comments (lines 47, 65, 87, and 88).


*/


class Exercise24_03 {
	public static void main(String[] args) {
		TwoWayLinkedList<Integer> list = new TwoWayLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		java.util.ListIterator<Integer> iterator = list.iterator();
		iterator.next();
		iterator.next();
		iterator.next();

		// System.out.print(iterator.next() + " ");

		System.out.println();
		while (iterator.hasPrevious())
		  System.out.print(iterator.previous() + " ");
	}
}