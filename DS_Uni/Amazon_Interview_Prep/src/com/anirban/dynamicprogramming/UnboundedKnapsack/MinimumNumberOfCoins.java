package com.anirban.dynamicprogramming.UnboundedKnapsack;

public class MinimumNumberOfCoins {

  public static void main(String[] args) {
    int coins[] = { 9, 6, 5, 1 };
    int m = coins.length;
    int V = 11;
    System.out.println("Minimum coins required is " + minCoins(coins, m, V));
  }

  private static int minCoins(int[] coins, int m, int v) {
    int t[][] = new int[m + 1][v + 1];
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < v + 1; j++) {
        if (i == 0)
          t[i][j] = Integer.MAX_VALUE - 1;
        if (j == 0)
          t[i][j] = 0;
      }
    }

    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < v + 1; j++) {
        if (j % coins[0] == 0)
          t[i][j] = j / coins[0];
        else
          t[i][j] = Integer.MAX_VALUE - 1;
      }
    }
    for (int i = 2; i < m + 1; i++) {
      for (int j = 2; j < v + 1; j++) {
        if (coins[i - 1] <= j)
          t[i][j] = Math.min(1 + t[i][j - coins[i - 1]], t[i - 1][j]);
        else
          t[i][j] = t[i - 1][j];
      }
    }
    return t[m][v];
  }
}
