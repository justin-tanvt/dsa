package learn.brocode;

import java.util.Arrays;

public class LearnInsertionSort {
	public static void main(String[] args) {
		int[] array = {9, 1, 8, 2, 7, 3, 6, 5, 4};
		System.out.println("before sort: " + Arrays.toString(array));
		insertionSort(array);
		System.out.println("insertion sort complete!");
	}	

	private static void insertionSort(int[] array) {
		// outer loop: for each elem, consider the subarray [0, i] and insert
		// the elem in its proper order within that subarray
		for (int outer = 1; outer < array.length; outer++) {
			// store outer loop element to temp var
			int temp = array[outer];

			// start inner loop at outer-1
			int inner = outer - 1;
			// inner loop: while temp smaller than array[inner]
			while (inner >=0 && temp < array[inner]) {
				// shift array[inner] right
				array[inner + 1] = array[inner];
				// replace array[inner] with temp
				array[inner] = temp;
				inner--;
			}
			System.out.println(Arrays.toString(array));
		}
	}
}