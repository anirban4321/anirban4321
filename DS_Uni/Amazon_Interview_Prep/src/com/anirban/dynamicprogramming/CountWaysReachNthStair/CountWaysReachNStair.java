package com.anirban.dynamicprogramming.CountWaysReachNthStair;

public class CountWaysReachNStair {

  public static void main(String[] args) {
    int m = 84;
    System.out.println(countWays(m));
  }

  static Long countWays(int m) {
    int N = 1000000007;
    if (m == 0 || m == 1)
      return 1l;
    long[] nums = new long[m + 1];
    nums[0] = 1l;
    nums[1] = 1l;

    for (int i = 2; i <= m; i++) {
      nums[i] = (nums[i - 1] + nums[i - 2]) % N;
    }
    return nums[m];

  }

}
