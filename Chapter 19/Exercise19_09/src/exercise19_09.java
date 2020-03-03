/*
 * Author:	Jason Waters
 * Date:	3/3/2020
 * Description: Exercise19_09
 * */

import java.util.ArrayList;

public class exercise19_09 {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(14);
		list.add(24);
		list.add(4);
		list.add(42);
		list.add(5);
		exercise19_09.<Integer>sort(list);
		System.out.print(list);
		
	}
	
	public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
		
		E min;
		int minI;

		for (int i = 0; i < list.size() - 1; i++) {

			min = list.get(i);
			minI = i;

			for (int j = i + 1; j < list.size(); j++) {
				if (min.compareTo(list.get(j)) > 0) {
					min = list.get(j);
					minI = j;
				}
			}

			if (minI != i) {
				list.set(minI, list.get(i));
				list.set(i, min);
			}
		}
	}
}
 