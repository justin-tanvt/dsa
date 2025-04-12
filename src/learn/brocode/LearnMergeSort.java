package learn.brocode;

import java.util.Arrays;

public class LearnMergeSort {
	public static void main(String[] args) {
		int[] array = {8, 2, 5, 3, 4, 7, 6, 1};
		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void mergeSort(int[] array) {
		int length = array.length;

		// base case - array of size 1
		// do nothing and return, since size 1 array is "sorted"
		if (length == 1) {
			return;
		}

		// split array into smaller arrays
		int middle = length / 2;
		int[] A = Arrays.copyOfRange(array, 0, middle);
		int[] B = Arrays.copyOfRange(array, middle, length);
		System.out.println(Arrays.toString(array) + " -> " + 
			Arrays.toString(A) + ", " + Arrays.toString(B));
		// pass smaller arrays into mergeSort again
		mergeSort(A);
		mergeSort(B);
		// merge sorted smaller arrays
		merge(A, B, array);
		System.out.println(Arrays.toString(A) + " + " + 
			Arrays.toString(B) + " -> " + Arrays.toString(array));
	}

	private static void merge(int[] leftArray, int[] rightArray, int[] mergedArray) {
		int leftSize = leftArray.length;
		int rightSize = rightArray.length;
		int mergedSize = mergedArray.length;

		int l = 0, r = 0, i = 0;

		while (i < mergedSize) {
			// IF right array fully consumed OR
			// left and right arrays not fully consumed AND left array value < right array value
			if (r == rightSize || l != leftSize && leftArray[l] < rightArray[r]) {
				// fill merged array with left array
				mergedArray[i] = leftArray[l];
				l++;
			// ELSE (IMPLICIT IF) left array fully consumed OR
			// left and right arrays not fully consumed AND left array value > right array value
			} else {
				// fill merged array with right array
				mergedArray[i] = rightArray[r];
				r++;
			}	
			i++;
		}
	}

}