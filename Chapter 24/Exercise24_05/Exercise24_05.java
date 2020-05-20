/*
Assignment Author: Jason Waters
Date: 5/20/2020
Exercise: 24-05
Class: CSCI 1115

Discription: 
(Implement GenericQueue using inheritance) In Section 24.5, GenericQueue is implemented using composition. This means that a LinkedList object is created inside of the class and then is used to access LinkedList's methods.

Another way of creating GenericQueue is using inheritance. Instead of creating an instance of LinkedList in the object class, GenericQueue can extend LinkList and access its methods that way.

Create a new GenericQueue class that uses inheritance. Create a test method that uses both the enqueue and dequeue methods and prints how the queue is affected.
*/
public class Exercise24_05 {
	public static void main(String[] args) {
		// Create a queue
		GenericQueue<String> queue = new GenericQueue<>();

		// Add elements to the queue
		queue.enQueue("Raphael"); // Add it to the queue
		System.out.println("1st Queue: " + queue);

		queue.enQueue("Donatello"); // Add it to the queue
		System.out.println("2nd Queue: " + queue);

		queue.enQueue("Leonardo"); // Add it to the queue
		System.out.println("3rd Queue: " + queue);
				
		queue.enQueue("Michelangelo"); // Add it to the queue
		System.out.println("4th Queue: " + queue);

		// Remove elements from the queue
		System.out.println("1st deQueue: " + queue.deQueue() + " Removed");
		System.out.println("result: " + queue);
		
		System.out.println("2nd deQueue: " + queue.deQueue() + " Removed");
		System.out.println("result: " + queue);
		
		System.out.println("3rd deQueue: " + queue.deQueue() + " Removed");
		System.out.println("result: " + queue);
		

	}
}