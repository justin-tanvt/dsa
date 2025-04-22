package interview;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorisation {
  public static void main(String[] args) {
    System.out.println(primeFactorisation(5));
    System.out.println(primeFactorisation(7));
    System.out.println(primeFactorisation(12));
    System.out.println(primeFactorisation(15));
    System.out.println(primeFactorisation(124948012));
  }

  private static List<Integer> primeFactorisation(int n) {
    List<Integer> factors = new ArrayList<>();

    for (int f = 2; f <= n; f++) {
      // while number is divisible by factor
      while (n % f == 0) {
        // divide n by f
        n /= f;
        // add f to factors
        factors.add(f);
      }

      // number no longer divisible by factor
      // move onto next factor
    }

    return factors;
  }

}