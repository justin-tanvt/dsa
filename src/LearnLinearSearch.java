import java.util.Arrays;

public class LearnLinearSearch {
	public static void main(String[] args) {
		char[] alphabets = new char[26];
		int UPPERCASE_ALPHABETS_ASCII_OFFSET = 65;

		for (int i = 0; i < 26 * 2; i++) {
			alphabets[i] = (char) (i + UPPERCASE_ALPHABETS_ASCII_OFFSET);
		}

		System.out.println(Arrays.toString(alphabets));
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