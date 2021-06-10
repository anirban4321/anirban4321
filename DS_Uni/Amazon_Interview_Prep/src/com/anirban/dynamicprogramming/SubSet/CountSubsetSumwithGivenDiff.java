package com.anirban.dynamicprogramming.SubSet;

/*
s1-s2=diff
s1+s2=sum
2*s1=diff+sum
s1=diff+sum/2
 */
public class CountSubsetSumwithGivenDiff {

  public static void main(String[] args) {
    int arr[] = { 1, 2, 1, 3 };
    int diff = 1;
    System.out.println(countSubsetSumWithGivenDiff(arr, diff));
  }

  private static int countSubsetSumWithGivenDiff(int[] array, int diff) {
    int sum = 0;
    for (int i = 0; i < array.length; i++)
      sum += array[i];
    int result = (sum + diff) / 2;
    return countSubsetSum(array, result);
  }

  private static int countSubsetSum(int[] array, int result) {
    int resultMatrix[][] = new int[array.length + 1][result + 1];
    for (int i = 0; i < array.length + 1; i++) {
      for (int j = 0; j < result + 1; j++) {
        if (i == 0)
          resultMatrix[i][j] = 0;
        if (j == 0)
          resultMatrix[i][j] = 1;
      }
    }

    for (int i = 1; i < array.length + 1; i++) {
      for (int j = 1; j < result + 1; j++) {
        if (array[i - 1] <= j)
          resultMatrix[i][j] = resultMatrix[i - 1][j - array[i - 1]] + resultMatrix[i - 1][j];
        else
          resultMatrix[i][j] = resultMatrix[i - 1][j];
      }
    }
    return resultMatrix[array.length][result];
  }

}
