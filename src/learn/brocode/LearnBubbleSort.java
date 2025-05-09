package learn.brocode;

import java.util.Arrays;

public class LearnBubbleSort {
	public static void main(String[] args) {
		int[] array = {9, 1, 8, 2, 7, 3, 6, 4, 5};

		bubbleSort(array);

		System.out.println("sort complete!");
	}	

	private static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
				System.out.println(Arrays.toString(array));
			}
		}	
	}
}