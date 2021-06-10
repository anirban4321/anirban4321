package com.anirban.dynamicprogramming.SubSet;

public class SubsetSum {

  public static void main(String[] args) {
    int array[] = { 1, 2, 1, 3, 5 };
    int sum = 10;
    System.out.println(isSubsetSum(array, sum));
  }

  private static boolean isSubsetSum(int[] array, int sum) {
    boolean result[][] = new boolean[array.length + 1][sum + 1];
    for (int i = 0; i < array.length + 1; i++) {
      for (int j = 0; j < sum + 1; j++) {
        if (i == 0)
          result[i][j] = false;
        if (j == 0)
          result[i][j] = true;
      }
    }
    for (int i = 1; i < array.length + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (array[i - 1] <= j) {
          result[i][j] = result[i - 1][j - array[i - 1]] || result[i - 1][j];
        } else
          result[i][j] = result[i - 1][j];
      }
    }
    return result[array.length][sum];
  }
}
