package com.anirban.dynamicprogramming.lcs;

public class LongestCommonSubstring {

  public static void main(String[] args) {
    String a = "OldSite:GeeksforGeeks.org";
    String b = "NewSite:GeeksQuiz.com";
    int m = a.length();
    int n = b.length();
    System.out.println(dPFindLengthLCSubstring(a, b, m, n));
  }

  private static int dPFindLengthLCSubstring(String a, String b, int m, int n) {
    int result[][] = new int[m + 1][n + 1];
    int ans = 0;
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        if (i == 0 || j == 0)
          result[i][j] = 0;
      }
    }
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
          result[i][j] = 1 + result[i - 1][j - 1];
          ans = Integer.max(ans, result[i][j]);
        } else
          result[i][j] = 0;
      }
    }
    return ans;
  }

}
