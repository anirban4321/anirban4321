package com.anirban.dynamicprogramming.KnapsackProblem;

public class RecursiveZeroOneKnapsack {

  public static void main(String[] args) {
    /*Scanner scanner = new Scanner(System.in);
    int weightArraySize = scanner.nextInt();
    //int valueArraySize =scanner.nextInt();
    int weight = scanner.nextInt();
    int weightArray[] = new int[weightArraySize];
    int valueArray[] = new int[weightArraySize];*/
    int valueArray[] = new int[] { 60, 100, 120 };
    int weightArray[] = new int[] { 10, 20, 30 };
    int weight = 50;
    int weightArraySize = 3;
    /*for (int start = 0; start < weightArraySize; start++) {
      weightArray[start] = scanner.nextInt();
      valueArray[start] = scanner.nextInt();
    }*/
    int maxProfit = recursiveZeroOneKnapSack(weightArray, valueArray, weight, weightArraySize);
    System.out.println("Maximum Profit::" + maxProfit);
  }

  private static int recursiveZeroOneKnapSack(int[] weightArray, int[] valueArray, int weight, int weightArraySize) {
    if (weightArraySize == 0 || weight == 0)
      return 0;

    if (weightArray[weightArraySize - 1] <= weight) {
      int remainingWeight = weight - weightArray[weightArraySize - 1];
      return Math.max((valueArray[weightArraySize - 1] + recursiveZeroOneKnapSack(weightArray,
          valueArray,
          remainingWeight,
          weightArraySize - 1)),
          recursiveZeroOneKnapSack(weightArray, valueArray, weight, weightArraySize - 1));
    } else
      return recursiveZeroOneKnapSack(weightArray, valueArray, weight, weightArraySize - 1);
  }
}
