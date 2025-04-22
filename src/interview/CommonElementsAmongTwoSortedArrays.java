package interview;

import java.util.ArrayList;
import java.util.List;

public class CommonElementsAmongTwoSortedArrays {

  public static List<Integer> findCommonElementsByTraversal(int[] A, int[] B) {
    List<Integer> ans = new ArrayList<>();
    int idxA = 0;
    int idxB = 0;

    while (idxA < A.length && idxB < B.length) {
      if (A[idxA] < B[idxB]) {
        // element A smaller than element B, increment index A
        idxA++;
      } else if (A[idxA] > B[idxB]) {
        // element B smaller than element A, increment index B
        idxB++;
      } else {
        // common element
        ans.add(A[idxA]);
        idxA++;
        idxB++;
      }
    }

    return ans;
  }

  public static List<Integer> findCommonElementsBySearch(int[] A, int[] B) {
    List<Integer> ans = new ArrayList<>();

    int[] smaller = (A.length <= B.length) ? A : B;
    int[] bigger  = (A.length > B.length) ? A : B;
    for (int elemSmall : smaller) {
      if (getIndexOf(bigger, elemSmall) != -1) {
        ans.add(elemSmall);
      }
    }

    return ans;
  }

  public static int getIndexOf(int[] arr, int target) {
    // edge case, target not in array
    if (arr.length == 0 || target < arr[0] || target > arr[arr.length - 1]) {
      return -1;
    }

    // binary search
    int leftIdx = 0;
    int rightIdx = arr.length - 1;
    while (leftIdx <= rightIdx) {
      int midIdx = leftIdx + (rightIdx - leftIdx) / 2;
      int midVal = arr[midIdx];

      if (target == midVal) {         // target found
        return midIdx;
      } else if (target < midVal) {   // target in 1st half
        rightIdx = midIdx - 1;
      } else {                        // target in 2nd half
        leftIdx = midIdx + 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[][] testA = {
        {1, 2, 3, 4, 5, 8, 9, 14, 16, 22, 400},
        {1, 3, 5, 7, 9},
        {1, 2, 3, 4, 5},
        {},
        {1, 2, 3, 4, 5},
        {},
        {1, 2, 3, 4, 5},
        new int[100000],  // Large test case
        {1, 2, 2, 3, 3, 3, 4, 5},
        {1, 1, 2, 2, 3, 3},
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
        {-10, -5, 0, 3, 5, 9},
        {7},
        {7}
    };

    int[][] testB = {
        {2, 3, 4, 6, 7, 9, 16},
        {2, 4, 6, 8, 10},
        {1, 2, 3, 4, 5},
        {1, 2, 3, 4, 5},
        {},
        {},
        {5},
        new int[100000],  // Large test case
        {2, 2, 3, 4, 4, 5, 6},
        {1, 1, 2, 2, 3, 3},
        {3, 4, 5, 6, 7},
        {-5, 0, 2, 3, 8, 10},
        {7},
        {8}
    };

    String[] expectedOutputs = {
        "[2, 3, 4, 9, 16]", // 1. Normal Case
        "[]", // 2. No Common Elements
        "[1, 2, 3, 4, 5]", // 3. Identical Arrays
        "[]", // 4. One Empty Array
        "[]", // 4. One Empty Array
        "[]", // 5. Both Empty
        "[5]", // 6. One Element Common
        "[2, 4, 6, 8, 10]", // 7. Large Arrays (Sample)
        "[2, 2, 3, 4, 5]", // 8. Duplicates in Arrays
        "[1, 1, 2, 2, 3, 3]", // 9. All Elements Common (Duplicates)
        "[3, 4, 5, 6, 7]", // 10. One Array is a Subset
        "[-5, 0, 3]", // 11. Negative Numbers
        "[7]", // 12. One Element (Same)
        "[]" // 13. One Element (Different)
    };

    for (int i = 0; i < testA.length; i++) {
      System.out.println("Test Case " + (i + 1) + ":");
      System.out.println("  Expected: " + expectedOutputs[i]);
      System.out.println("  Traversal: " + findCommonElementsByTraversal(testA[i], testB[i]));
      System.out.println("  Binary Search: " + findCommonElementsBySearch(testA[i], testB[i]));
      System.out.println();
    }
  }

}
