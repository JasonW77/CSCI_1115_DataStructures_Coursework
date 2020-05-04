/*
Author: Jason Waters
Date: 5/1/2020
Exercise: 23-3

Description: 
  
  Generic quick sort ) Write the following two generic methods using quick sort. The first method sorts the elements using the Comparable interface and the second uses the Comparator interface.
*/

import java.util.Comparator;

public class Exercise23_03 {
  
  //quick sort methods for using Comparable 
    public static <E extends Comparable<E>> void quickSort(E[] list) {
      quickSort(list, 0, list.length - 1);
    }

    public static <E extends Comparable<E>> 
        void quickSort(E[] list, int first, int last) {
      if (last > first) {
        int pivotIndex = partition(list, first, last);
        quickSort(list, first, pivotIndex - 1);
        quickSort(list, pivotIndex + 1, last);
      }
    }

    public static <E extends Comparable<E>> 
        int partition(E[] list, int first, int last) {
      E pivot = list[first]; 
      int low = first + 1; 
      int high = last; 

      while (high > low) {
        while (low <= high && list[low].compareTo(pivot) <= 0)
          low++;

        
        while (low <= high && list[high].compareTo(pivot) > 0)
          high--;

      
        if (high > low) {
          E temp = list[high];
          list[high] = list[low];
          list[low] = temp;
        }
      }

      while (high > first && list[high].compareTo(pivot) >= 0)
        high--;

      
      if (pivot.compareTo(list[high]) > 0) {
        list[first] = list[high];
        list[high] = pivot;
        return high;
      }
      else {
        return first;
      }
    }
    
  //quick sort methods for using Comparator
  public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
      quickSort(list, 0, list.length - 1, comparator);
    }

    public static <E> void quickSort(
        E[] list, int first, int last, Comparator<? super E> comparator) {
      if (last > first) {
        int pivotIndex = partition(list, first, last, comparator);
        quickSort(list, first, pivotIndex - 1, comparator);
        quickSort(list, pivotIndex + 1, last, comparator);
      }
    }

    
    public static <E> int partition(
        E[] list, int first, int last, Comparator<? super E> comparator) {
      E pivot = list[first]; 
      int low = first + 1; 
      int high = last; 

      while (high > low) {
        
        while (low <= high && comparator.compare(list[low], pivot) <= 0)
          low++;

        
        while (low <= high && comparator.compare(list[high], pivot) > 0)
          high--;

        
        if (high > low) {
          E temp = list[high];
          list[high] = list[low];
          list[low] = temp;
        }
      }

      while (high > first && comparator.compare(list[high], pivot) >= 0)
        high--;

      
      if (comparator.compare(pivot, list[high]) > 0) {
        list[first] = list[high];
        list[high] = pivot;
        return high;
      }
      else {
        return first;
      }
    }

  //provided test method
  public static void main(String[] args) {
    Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    quickSort(list);
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }

    System.out.println();
    
    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                     new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                     new Circle(3), new Circle(14), new Circle(12)};
    quickSort(list1, new GeometricObjectComparator());
    for (int i = 0; i < list1.length; i++) {
      System.out.println(list1[i] + " ");
    }
    
  }
}


/**

This is the method i used to give me a starting point to build the comparable and comparator methods above this method. I got it from the book.

    
  public static void quickSort(Integer[] list) {
    quickSort(list, 0, list.length - 1);
  }
  
  public static void quickSort(Integer[] list, Integer first, Integer last){
    if (last > first) {
      Integer pivotIndex = partition(list, first, last);
      quickSort(list, first, pivotIndex - 1);
      quickSort(list, pivotIndex + 1, last);
    }
  }
  
  //partition the array list first/last
  public static Integer partition(Integer[] list, Integer first, Integer last) {
    Integer pivot = list[first];   // Choose the first element as the pivot
    Integer low = first + 1;       // Index for forward search or low to high
    Integer high = last;          // Index for backward search or high to low
    
    while (high > low) {
      // Search forward from left or low to high
      while (low <= high && list[low] <= pivot)
      low++;
      
      // Search backward from right or high to low
      while (low <= high && list[high] > pivot)
      high--;
      
      // Swap two elements in the list
      if (high > low) {
        Integer temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }
    
    while (high > first && list[high] >= pivot)
    high--;
    
    // Swap pivot with list[high]
    if (pivot > list[high]) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    }
    else {
      return first;
    }
  }
  
*/