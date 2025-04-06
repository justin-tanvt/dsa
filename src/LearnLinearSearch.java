import java.util.Arrays;

public class LearnLinearSearch {
	public static void main(String[] args) {
		int UPPERCASE_ALPHABETS_ASCII_OFFSET = 65;
		int NUMBER_OF_CHARS = 26;

		char[] alphabets = new char[NUMBER_OF_CHARS];
		for (int i = 0; i < NUMBER_OF_CHARS; i++) {
			alphabets[i] = (char) (i + UPPERCASE_ALPHABETS_ASCII_OFFSET);
		}

		System.out.println(Arrays.toString(alphabets));

		int index = linearSearch(alphabets, 'Z');
		if (index != -1) {
			System.out.println("element found at index: " + index);
		} else {
			System.out.println("element not found");
		}
	}	

	private static int linearSearch(char[] array, char value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				return i;
			}
		}	
		return -1;
	}
}