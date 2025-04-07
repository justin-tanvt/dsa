import java.util.Arrays;

public class LearnInterpolationSearch {
	public static void main(String[] args) {
		int[] array = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
		int target = 256;

		int index = interpolationSearch(array, target);

		if (index != -1) {
			System.out.println("element found at index: " + index);
		} else {
			System.out.println("element not found");
		}
	}	

	private static int interpolationSearch(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		int i = 0;

		while (left <= right && target >= array[left] && target <= array[right]) {
			i++;
			int probe = left + (right - left) * (target - array[left]) / (array[right] - array[left]);
			int value = array[probe];

			System.out.printf("\niteration [%s]\n", i);
			System.out.printf("\tleft: \t%s\n", left);
			System.out.printf("\tprobe: \t%s\n", probe);
			System.out.printf("\tright: \t%s\n", right);
			// System.out.println(Arrays.toString(Arrays.copyOfRange(array, left, right)));

			if (target == value) {
				System.out.println("target found!");
				return probe;
			} else if (target < value) {
				System.out.println("target in lower half");
				right = probe - 1;
			} else {
				System.out.println("target in upper half");
				left = probe + 1;
			}
		}

		return -1;
	}
}