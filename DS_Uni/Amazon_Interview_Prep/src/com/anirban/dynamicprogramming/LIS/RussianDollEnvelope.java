package com.anirban.dynamicprogramming.LIS;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelope {

  public static void main(String[] args) {
    int[][] m = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
    int res = maxEnvelopes(m);
    System.out.println(res);
  }

  public static int maxEnvelopes(int[][] envelopes) {
    int count = 1;
    int n = envelopes.length;
    if (n == 0)
      return 0;

    Arrays.sort(envelopes, Comparator.comparingInt(o -> o[0]));
    /*Arrays.sort(envelopes, new Comparator<int[]>() {

          @Override
          public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[0], o2[0]);
          }
        });*/
    int dp[] = new int[n + 1];
    for (int i = 0; i < n + 1; i++) {
      dp[i] = 1;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1] && dp[i] < dp[j] + 1)
          dp[i] = dp[j] + 1;
      }
      if (count < dp[i])
        count = dp[i];
    }
    return count;
  }
}
