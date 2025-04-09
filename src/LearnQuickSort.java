import java.util.Arrays;

public class LearnQuickSort {
	public static void main(String[] args) {
		int[] arrayIllustrated = {8, 2, 4, 7, 1, 3, 9, 6, 5};
		int[] array = {8, 2, 5, 3, 9, 4, 7, 6, 1};

		int[] toSort = arrayIllustrated;
		quickSort(toSort, 0, toSort.length - 1);
		System.out.println(Arrays.toString(toSort));
	}

	private static void quickSort(int[] array, int start, int end) {
		// base case (invalid, empty or size-1 array) - no need to sort
		if (start >= end) return;

		// not base case (valid array) - need to sort
		System.out.println("sorting : " + Arrays.toString(
			Arrays.copyOfRange(array, start, end + 1)));

		// use element at end as pivot to bisect the array(problem) into
		// subarrays(subproblems)
		int pivot = array[end];

		// this can be done by sorting the pivot to its correct
		// position in the array and while doing so, ensuring that:
			// all smaller values are leftwards of the pivot
			// all bigger values are rightwards of the pivot

		// implement this using 2-pointer technique
		// left pointer indicates index of elements smaller than pivot
		// right pointer loops through all elements except pivot

		// left pointer begins at -1 (relative to start)
		// since no smaller elements found yet
		int l = start - 1;
		for (int r = start; r < end; r++) {
			// if right pointer finds element smaller than pivot
			if (array[r] < pivot) {
				// increment left pointer (i.e. increase smaller element count)
				l++;
				// swap values at left and right pointers to ensure that
				// any elements smaller than pivot are at or before left pointer
				swap(array, l, r);
			}
		}
		// all elements have been compared to pivot
		// any elements smaller than pivot are at or before left pointer

		// hence, pivot's correct position is left pointer + 1
		int pivotIndex = l + 1;
		// move pivot from end to its rightful position
		swap(array, end, pivotIndex);

		// now that pivot has been located, any subarray(s) resulting from 
		// bisecting the main array at the pivot and excluding the pivot itself
		// are subproblems of the original problem (i.e. suitable for recursion)

		// hence, apply quicksort to resulting subarray(s)
		// edge case (invalid subarray indices) is handled by base case
		quickSort(array, start, pivotIndex - 1);
		quickSort(array, pivotIndex + 1, end);
	}

	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}