package com.anirban.dynamicprogramming.SubSet;

import java.util.Vector;

/*
Sum of subset differences
Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

Example:
Input:  arr[] = {1, 6, 11, 5}
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11}, sum of Subset2 = 11
 */


public class MinimumSubsetSumDifference {

  public static void main(String[] args) {
    int arr[] = { 1, 6, 11, 5, 1 };
    System.out.println(countMinimumSubsetSumDifference(arr));
  }

  //sum(S2)-sum(S1) belongs to range (0 to sum of all array elements)--eqn(1)
  //sum(S1)+sum(S2)=range
  //=>sum(S2)=range-sum(S1) ----eqn(2)
  //substituting in first equation we get:
  //range-2*sum(S2) belongs to range (0 to sum of all array elements)
  //in the above example:
  //{1, 6, 11, 5}
  //range is 1+6+11+5=23
  //subset sum will not equal with all elements between 1 and 23
  //so the last row elements from the matrix whose values are true will only contribute
  //from the last row will take half of the elements and will put in the eqn(2).

  private static int countMinimumSubsetSumDifference(int array[]) {
    //int result[][]=new int[array.length+1][range+1];
    int range = 0;
    for (int i = 0; i < array.length; i++)
      range += array[i];
    Vector<Integer> candidateMinDiffElements;
    candidateMinDiffElements = fetchCandidateElements(array, range);
    int minDiff = Integer.MAX_VALUE;

    for (int i = 0; i < candidateMinDiffElements.size(); i++) {
      int result = range - 2 * candidateMinDiffElements.get(i);
      if (result < minDiff)
        minDiff = result;
    }
    return minDiff;
  }

  private static Vector<Integer> fetchCandidateElements(int[] array, int range) {
    boolean result[][] = new boolean[array.length + 1][range + 1];
    for (int i = 0; i < array.length + 1; i++) {
      for (int j = 0; j < range + 1; j++) {
        if (i == 0)
          result[i][j] = false;
        if (j == 0)
          result[i][j] = true;
      }
    }

    for (int i = 1; i < array.length + 1; i++) {
      for (int j = 1; j < range + 1; j++) {
        if (array[i - 1] <= j)
          result[i][j] = result[i - 1][j - array[i - 1]] || result[i - 1][j];
        else
          result[i][j] = result[i - 1][j];
      }
    }
    Vector<Integer> candidateMinDiffElements = new Vector<>();
    for (int i = 0; i < result[array.length - 1].length / 2; i++) {
      if (result[array.length - 1][i] == true)
        candidateMinDiffElements.add(i);
    }
    return candidateMinDiffElements;
  }
}
