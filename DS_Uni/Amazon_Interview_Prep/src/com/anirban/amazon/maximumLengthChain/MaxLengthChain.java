package com.anirban.amazon.maximumLengthChain;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChain {

  public static int maxChainLength(Pair arr[], int n) {
    int max = 1;
    Arrays.sort(arr, Comparator.comparingInt(o -> o.x));

    int[] result = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      result[i] = 1;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i].x > arr[j].y && result[i] < 1 + result[j]) {
          result[i] = 1 + result[j];
          if (max < result[i])
            max = result[i];
        }
      }
    }
    return max;
  }
}
