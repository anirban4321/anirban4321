package com.anirban.dynamicprogramming.lcs;

/*
Printing Longest Common Subsequence
Given two sequences, print the longest subsequence present in both of them.
Example:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 */
public class ShortestCommonSuperSequence {

  public static void main(String[] args) {
    String a = "AGGTAB";
    String b = "GXTXAYB";
    int m = a.length();
    int n = b.length();
    System.out.println(dPFindLengthSCS(a, b, m, n));
  }

  private static int dPFindLengthSCS(String a, String b, int m, int n) {
    int result[][] = new int[m + 1][n + 1];
    int totalLength = m + n;
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
    return totalLength - result[m][n];
  }

}
