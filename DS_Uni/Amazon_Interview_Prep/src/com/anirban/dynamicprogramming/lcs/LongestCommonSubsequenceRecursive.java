package com.anirban.dynamicprogramming.lcs;

public class LongestCommonSubsequenceRecursive {

  private static int[][] t;

  public static void main(String[] args) {
    String a = "waterrfetawx";
    String b = "xwatefrretaw";
    int m = a.length();
    int n = b.length();
    t = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        t[i][j] = -1;
      }
    }
    System.out.println(findLengthLCS(a, b, m, n));
    System.out.println(dPFindLengthLCS(a, b, m, n));
    System.out.println(recursiveMemorizedFindLength(a, b, m, n));
  }

  private static int recursiveMemorizedFindLength(String a, String b, int m, int n) {
    if (m == 0 || n == 0)
      return 0;
    if (t[m][n] != -1)
      return t[m][n];
    else {
      if (a.charAt(m - 1) == b.charAt(n - 1))
        t[m][n] = 1 + findLengthLCS(a, b, m - 1, n - 1);
      else
        t[m][n] = Math.max(findLengthLCS(a, b, m, n - 1), findLengthLCS(a, b, m - 1, n));
    }
    return t[m][n];

  }

  private static int findLengthLCS(String a, String b, int m, int n) {
    if (m == 0 || n == 0)
      return 0;
    if (a.charAt(m - 1) == b.charAt(n - 1))
      return 1 + findLengthLCS(a, b, m - 1, n - 1);
    else
      return Math.max(findLengthLCS(a, b, m, n - 1), findLengthLCS(a, b, m - 1, n));
  }

  private static int dPFindLengthLCS(String a, String b, int m, int n) {
    int[][] result = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        if (i == 0 || j == 0)
          result[i][j] = 0;
      }
    }
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (a.charAt(i - 1) == b.charAt(j - 1))
          result[i][j] = 1 + result[i - 1][j - 1];
        else {
          result[i][j] = Math.max(result[i][j - 1], result[i - 1][j]);
        }
      }
    }
    return result[m][n];
  }

}
