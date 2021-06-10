package com.anirban.dynamicprogramming.KnapsackProblem;

public class DPZeroOneKnapsack {

  public static void main(String[] args) {
    int valueArray[] = new int[] { 60, 100, 120 };
    int weightArray[] = new int[] { 10, 20, 30 };
    int weight = 50;
    int weightArraySize = 3;

    int maxProfit = TopDownKnapsack(weightArray, valueArray, weight, weightArraySize);
    System.out.println("Maximum Profit::" + maxProfit);
  }

  private static int TopDownKnapsack(int[] weightArray, int[] valueArray, int weight, int arraySize) {
    int result[][] = new int[arraySize + 1][weight + 1];
    //initialization
    for (int i = 0; i < arraySize + 1; i++) {
      for (int j = 0; j < weight + 1; j++) {
        if (i == 0 || j == 0)
          result[i][j] = 0;
      }
    }

    for (int i = 1; i < arraySize + 1; i++) {
      for (int j = 1; j < weight + 1; j++) {
        if (weightArray[i - 1] <= j) {
          result[i][j] = Math.max(valueArray[i - 1] + result[i - 1][j - weightArray[i - 1]], result[i - 1][j]);
        } else
          result[i][j] = result[i - 1][j];
      }
    }
    return result[arraySize][weight];
  }
}
