package interview;

public class IsPalindrome {
  public static void main(String[] args) {
    String yes = "ABA";
    String no = "APPLE";

    System.out.println(isPalindrome(yes));
    System.out.println(isPalindrome(no));
  }

  private static boolean isPalindrome(String str) {
    // get string length
    int length = str.length();
    // divide string length by half = k
    int k = length / 2;     // 5 / 2 = 2

    // for loop through k
    for (int i = 0; i <= k; i++) {
      // get char from left
      char l = str.charAt(i);
      // get char from right
      char r = str.charAt(length - i - 1);
      // if not equal return false
      if (l != r) {
        return false;
      }
    }

    return true;
  }
}
