package learn.brocode;

public class LearnRecursion {
	public static void main(String[] args) {
		System.out.println(iFactorial(7));
		System.out.println(rFactorial(7));
		System.out.println(power(2, 8));
	}

	private static int iFactorial(int num) {
		int ans = 1;
		for (int i = 1; i <= num; i++) {
			ans *= i;
		}
		return ans;
	}

	private static int rFactorial(int num) {
		// base case
		if (num == 1) {
			return 1;
		}

		return num * rFactorial(num - 1);
	}

	private static int power(int base, int exponent) {
		// base case
		if (exponent < 1) {
			return 1;
		}

		return base * power(base, exponent - 1);
	}
}