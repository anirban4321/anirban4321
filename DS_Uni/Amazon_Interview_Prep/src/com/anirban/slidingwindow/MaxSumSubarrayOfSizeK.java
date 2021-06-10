package com.anirban.slidingwindow;

public class MaxSumSubarrayOfSizeK {

  public static void main(String[] args) {
    int[] array = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
    int k = 4;
    System.out.println(countMaxSumSubarray(array, k));
  }

  private static int countMaxSumSubarray(int[] array, int k) {
    int length = array.length;
    int i = 0;
    int j = 0;
    int sum = 0;
    int max = 0;
    while (j < array.length) {
      sum = sum + array[j];
      if (j - i + 1 < k)
        j++;
      else if (j - i + 1 == k) {
        max = Math.max(max, sum);
        sum = sum - array[i];
        i++;
        j++;
      }
    }
    return max;
  }

  /*private static int countMaxSumSubarray(int[] array, int k) {
    int length = array.length;
    int start = 0;
    int end = 0;
    int sum = 0;
    for (int i = 0; i < k; ++i)
      sum += array[i];
    int ans = sum;
    for (int i = k; i < length; ++i) {
      sum = sum + array[i] - array[i - k];
      if (sum > ans) {
        ans = sum;
        start = i - k;
      }
    }
    end = start + k;
    System.out.println("subarray starting from" + start + "and ending at" + end + "has maximum sum");
    return ans;
  }*/
}
