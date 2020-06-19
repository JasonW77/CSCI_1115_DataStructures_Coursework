/*
Assignment Author: Jason Waters
Date: 6/19/2020
Exercise: 30-13
Class: CSCI 1115
Discription: 
(Generic parallel merge sort) Revise Listing 30.10 to define a generic parallelMergeSort method as follows:

public static <E extends Comparable<E>> void parallelMergeSort(E[] list) 
Download these files to start.

To test your method, your arrays must be of Object types. To fix this, change lines 7 and 8 to:

Integer[] list1 = new Integer[SIZE];
Integer[] list2 = new Integer[SIZE];
*/
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;

public class ParallelMergeSort {
	public static void main(String[] args) {
		final int SIZE = 7000000;
		Integer[] list1 = new Integer[SIZE];
		Integer[] list2 = new Integer[SIZE];
		
		for (int i = 0; i < list1.length; i++)
			list1[i] = list2[i] = (int)(Math.random() * 10000000);

		long startTime = System.currentTimeMillis();
		parallelMergeSort(list1); // Invoke parallel merge sort
		long endTime = System.currentTimeMillis();
		System.out.println("\nParallel time with "
			+ Runtime.getRuntime().availableProcessors() + 
			" processors is " + (endTime - startTime) + " milliseconds");

		startTime = System.currentTimeMillis();
		MergeSort.mergeSort(list2); // MergeSort is in Listing 24.5
		endTime = System.currentTimeMillis();
		System.out.println("\nSequential time is " + 
			(endTime - startTime) + " milliseconds");
	}
/*
	public static void parallelMergeSort(int[] list) {
		RecursiveAction maintask = new SortTask(list);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(maintask);
	}
	*/
	public static <E extends Comparable<E>> void parallelMergeSort(E[] list) {
		RecursiveAction maintask = new SortTask(list);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(maintask);
	}
	private static class SortTask<E extends Comparable<E>> extends RecursiveAction {
		private final int THRESHOLD = 500;
		private E[] list;

		SortTask(E[] list) {
			this.list = list;
		}

		@Override
		protected void compute() {
			if (list.length < THRESHOLD)
				java.util.Arrays.sort(list);
			else {
				// Obtain the first half
				E[] firstHalf = (E[])(new Comparable[list.length / 2]);
				System.arraycopy(list, 0, firstHalf, 0, list.length / 2);

				// Obtain the second half
				int secondHalfLength = list.length - list.length / 2;
				E[] secondHalf = (E[])(new Comparable[secondHalfLength]);
				System.arraycopy(list, list.length / 2, 
					secondHalf, 0, secondHalfLength);

				// Recursively sort the two halves
				invokeAll(new SortTask(firstHalf), 
					new SortTask(secondHalf));

				// Merge firstHalf with secondHalf into list
				MergeSort.merge(firstHalf, secondHalf, list);
			}
		}
	}
}