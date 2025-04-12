package learn.brocode;

import java.util.Arrays;

public class LearnBinarySearch {
	public static void main(String[] args) {
		int[] array = new int[1000000];
		int target = 777777;

		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}

		int index = binarySearch(array, target);

		if (index != -1) {
			System.out.println("element found at index: " + index);
		} else {
			System.out.println("element not found");
		}
	}	

	private static int binarySearch(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		int i = 0;

		while (left <= right) {
			i++;
			int mid = left + (right - left) / 2;
			int value = array[mid];

			System.out.printf("\niteration [%s]\n", i);
			System.out.printf("\tleft: \t%s\n", left);
			System.out.printf("\tmid: \t%s\n", mid);
			System.out.printf("\tright: \t%s\n", right);
			// System.out.println(Arrays.toString(Arrays.copyOfRange(array, left, right)));

			if (target == value) {
				System.out.println("target found!");
				return mid;
			} else if (target < value) {
				System.out.println("target in lower half");
				right = mid - 1;
			} else {
				System.out.println("target in upper half");
				left = mid + 1;
			}
		}

		return -1;
	}
}