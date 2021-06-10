package com.anirban.dynamicprogramming.UnboundedKnapsack;

public class UnboundedKnapsack {

  public static void main(String[] args) {
    int weightArray[] = { 1, 2, 3, 4, 5, 7, 8 };
    int priceArray[] = { 1, 5, 7, 8, 9, 10, 17 };
    int weight = 8;
    int maxProfit = unboundedKnapsack(weightArray, priceArray, weight, weightArray.length);
    System.out.println(maxProfit);
  }

  private static int unboundedKnapsack(int weightArray[], int valueArray[], int weight, int arraySize) {
    int result[][] = new int[arraySize + 1][weight + 1];
    for (int i = 0; i < arraySize + 1; i++) {
      for (int j = 0; j < weight + 1; j++) {
        if (i == 0 || j == 0)
          result[i][j] = 0;
      }
    }

    for (int i = 1; i < arraySize + 1; i++) {
      for (int j = 1; j < weight + 1; j++) {
        if (weightArray[i - 1] <= j)
          result[i][j] = Math.max(valueArray[i - 1] + result[i][j - weightArray[i - 1]], result[i - 1][j]);
        else
          result[i][j] = result[i - 1][j];
      }
    }
    return result[arraySize][weight];
  }
}
