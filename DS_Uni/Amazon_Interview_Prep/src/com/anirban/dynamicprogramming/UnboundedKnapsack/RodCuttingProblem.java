package com.anirban.dynamicprogramming.UnboundedKnapsack;

/*
Rod Cutting Problem
 Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the  maximum value obtainable by cutting up the rod and selling the pieces.
Example:
if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)


length   | 1   2   3   4   5   6   7   8
--------------------------------------------
price    | 1   5   8   9  10  17  17  20
 */
public class RodCuttingProblem {

  private static int maximumProfit(int length[], int price[], int lengthOfRod, int size) {
    int result[][] = new int[size + 1][lengthOfRod + 1];
    for (int i = 0; i < size + 1; i++) {
      for (int j = 0; j < lengthOfRod + 1; j++) {
        if (i == 0 || j == 0)
          result[i][j] = 0;
      }
    }
    for (int i = 1; i < size + 1; i++) {
      for (int j = 1; j < lengthOfRod + 1; j++) {
        if (length[i - 1] <= j)
          result[i][j] = Math.max(price[i - 1] + result[i][j - length[i - 1]], result[i - 1][j]);
        else
          result[i][j] = result[i - 1][j];
      }
    }
    return result[size][lengthOfRod];
  }

  public static void main(String[] args) {
    int[] length = { 1, 2, 3, 4, 5, 6, 7, 8 };
    int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
    int lengthOfRod = 8;
    int maxProfit = maximumProfit(length, price, lengthOfRod, price.length);
    System.out.println(maxProfit);
  }
}
