import java.util.Arrays;

public class LearnSelectionSort {
	public static void main(String[] args) {
		int[] array = {9, 1, 8, 2, 7, 3, 6, 4, 5};
		System.out.println("before sort: " + Arrays.toString(array));
		selectionSort(array);
		System.out.println("selection sort complete!");
	}	

	private static void selectionSort(int[] array) {
		// outer loop : sort elements one-by-one from left -> right
		// end outer loop at n-1, because last element will already be sorted
		for (int i = 0; i < array.length - 1; i++) {

			// inner loop : iterate through all elements
			// assign starting values for min value and min idx
			int minVal = array[i];
			int minIdx = array[i];
			for (int j = i; j < array.length; j++) {
				// note min value
				// note min index
				if (array[j] < minVal) {
					minVal = array[j];
					minIdx = j;
				}
			}
			// inner loop completes

			// swap current element in outer loop with min value element
			// store current element in temp variable
			int temp = array[i];
			// assign min value to outer loop index
			array[i] = minVal;
			// assign current element value to min value index
			array[minIdx] = temp;

			System.out.println(Arrays.toString(array));
		}
		// outer loop completes
	}
}