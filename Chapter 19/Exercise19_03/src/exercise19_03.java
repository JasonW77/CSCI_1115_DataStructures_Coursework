/*	Author: Jason Waters
	Date:	3/3/2020
	Description: Exercise19_03.java
*/

import java.util.ArrayList;

public class exercise19_03 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(14);
		list.add(24);
		list.add(14);
		list.add(42);
		list.add(25);
		ArrayList<Integer> newList = removeDuplicates(list);
		System.out.print(newList);
	}
		public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
			
			ArrayList<E> newList = new ArrayList<>(list.size());
			for (E originalList : list) {
				if (!newList.contains(originalList)) {
					newList.add(originalList);
				}
			}
			
			return newList;
	}
}


