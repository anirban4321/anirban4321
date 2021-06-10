package com.anirban.dynamicprogramming.UnboundedKnapsack;

/*
Given a value N, if we want to make change for N cents,
and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
how many ways can we make the change? The order of coins doesn’t matter.
For example, for N = 4 and S = {1,2,3},
there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
So output should be 4.
For N = 10 and S = {2, 5, 3, 6},
there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
So the output should be 5
 */
public class CoinMaximumNumberOfWays {

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3 };
    int coins[] = { 2, 5, 3, 6 };
    int m = coins.length;
    System.out.println(countMaxWaysOfCoinChange(coins, m, 10));
  }

  private static int countMaxWaysOfCoinChange(int[] arr, int m, int n) {
    int t[][] = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        if (i == 0)
          t[i][j] = 0;
        if (j == 0)
          t[i][j] = 1;
      }
    }

    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (arr[i - 1] <= j)
          t[i][j] = t[i][j - arr[i - 1]] + t[i - 1][j];
        else
          t[i][j] = t[i - 1][j];
      }
    }
    return t[m][n];
  }
}
