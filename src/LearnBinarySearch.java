import java.util.Arrays;

public class LearnBinarySearch {
	public static void main(String[] args) {
		int UPPERCASE_ALPHABETS_ASCII_OFFSET = 65;
		int NUMBER_OF_CHARS = 26;

		char[] alphabets = new char[NUMBER_OF_CHARS];
		for (int i = 0; i < NUMBER_OF_CHARS; i++) {
			alphabets[i] = (char) (i + UPPERCASE_ALPHABETS_ASCII_OFFSET);
		}

		System.out.println(Arrays.toString(alphabets));

		int index = binarySearch(alphabets, 'Z');
		if (index != -1) {
			System.out.println("element found at index: " + index);
		} else {
			System.out.println("element not found");
		}
	}	

	private static int binarySearch(char[] array, char value) {
		int left = 0;
		int right = array.length - 1;
		int i = 0;

		while (left <= right) {
			i++;
			int mid = left + (right - left) / 2;

			System.out.printf("\niteration [%s]\n", i);
			System.out.printf("\tleft: %s\n", left);
			System.out.printf("\tmid: %s\n", mid);
			System.out.printf("\tright: %s\n", right);
			System.out.println(Arrays.toString(Arrays.copyOfRange(array, left, right)));

			if (value == array[mid]) {
				System.out.println("value found!");
				return mid;
			} else if (value < array[mid]) {
				System.out.println("value in lower half");
				right = mid - 1;
			} else {
				System.out.println("value in upper half");
				left = mid + 1;
			}
		}

		return -1;
	}
}