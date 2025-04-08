import java.util.Arrays;

public class LearnMergeSort {
	public static void main(String[] args) {
		int[] array = {8, 2, 5, 3, 4, 7, 6, 1};
		mergeSort(array);
		System.out.println(Arrays.deepToString(array));
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
		System.out.println(Arrays.deepToString(array) + " -> " + 
			Arrays.deepToString(A) + ", " + Arrays.deepToString(B));
		// pass smaller arrays into mergeSort again
		mergeSort(A);
		mergeSort(B);
		// merge sorted smaller arrays
		merge(A, B, array);
		System.out.println(Arrays.deepToString(A) + " + " + 
			Arrays.deepToString(B) + " -> " + Arrays.deepToString(array));
	}

	private static void merge(int[] leftArray, int[] rightArray, int[] mergedArray) {
		int idxA = 0;
		int idxB = 0;
		int idxMerged = 0;

		while (idxMerged < mergedArray.length) {
			if (idxB == rightArray.length || idxA != leftArray.length && leftArray[idxA] < rightArray[idxB]) {
				mergedArray[idxMerged] = leftArray[idxA];
				idxA++;
			} else {
				mergedArray[idxMerged] = rightArray[idxB];
				idxB++;
			}	
			idxMerged++;
		}
	}

}