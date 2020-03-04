/*
Author: Jason Waters
Date: 3/4/2020

Description: Exercise 20-21 for the CSCI 1115 Class at SouthWest Technical School
*/
import java.util.Comparator;

public class Exercise20_21 {
  public static void main(String[] args) {
    GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
        new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
        new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
        new Circle(6.5), new Rectangle(4, 5)};

    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
      new Circle(5), new Circle(6), new Circle(1), new Circle(2),
      new Circle(3), new Circle(14), new Circle(12)};
    selectionSort(list1, new GeometricObjectComparator());
    for (int i = 0; i < list1.length; i++)
      System.out.println(list1[i].getArea() + " ");
  }
  
  public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
	  
	  for (int i = 0; i < list.length - 1; i++) {
			// Find the minimum in the list[i..list.length-1]
			E curMin = list[i];
			int curMinIn = i;

			for (int j = i + 1; j < list.length; j++) {
				if (comparator.compare(curMin, list[j]) > 0) {
				curMin = list[j];
				curMinIn = j;
			}
		}

		// Swap list[i] with list[currentMinIndex] if necessary
		if (curMinIn != i) {
				list[curMinIn] = list[i];
				list[i] = curMin;
			}
	  }
  
  }
}