package com.anirban.dynamicprogramming.KnapsackProblem;

public class RecursiveMemorizeZeroOneKnapsack {

  private static int result[][];

  public static void main(String[] args) {
    int valueArray[] = new int[] { 60, 100, 120 };
    int weightArray[] = new int[] { 10, 20, 30 };
    int weight = 50;
    int weightArraySize = 3;

    result = new int[weightArraySize + 1][weight + 1];
    for (int i = 0; i < weightArraySize + 1; i++) {
      for (int j = 0; j < weight + 1; j++) {
        result[i][j] = -1;
      }
    }

    int maxProfit = recursiveMemorizeZeroOneKnapsack(weightArray, valueArray, weight, weightArraySize);
    System.out.println("Maximum Profit::" + maxProfit);
  }

  private static int recursiveMemorizeZeroOneKnapsack(
      int[] weightArray, int[] valueArray, int weight, int arraySize) {
    if (arraySize == 0 || weight == 0)
      return 0;
    if (result[arraySize][weight] != -1)
      return result[arraySize][weight];
    else {
      if (weightArray[arraySize - 1] <= weight) {
        result[arraySize][weight] = Math.max(
            valueArray[arraySize - 1] + recursiveMemorizeZeroOneKnapsack(weightArray,
                valueArray,
                weight - weightArray[arraySize - 1],
                arraySize - 1),
            recursiveMemorizeZeroOneKnapsack(weightArray, valueArray, weight, arraySize - 1));
      } else
        result[arraySize][weight] = recursiveMemorizeZeroOneKnapsack(weightArray, valueArray, weight, arraySize - 1);
    }

    return result[arraySize][weight];
  }
}
