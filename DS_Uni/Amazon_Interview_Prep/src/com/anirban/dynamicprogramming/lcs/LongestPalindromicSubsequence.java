package com.anirban.dynamicprogramming.lcs;

/*
Given a sequence, find the length of the longest palindromic subsequence in it.
 */
public class LongestPalindromicSubsequence {

  public static void main(String[] args) {
    String seq = "GEEKSFORGEEKS";
    String reverseSeq = new StringBuilder(seq).reverse().toString();
    int n = seq.length();
    System.out.printf("The length of the LPS is %d", lps(seq, reverseSeq, n));

  }

  private static int lps(String a, String b, int m) {
    int n = b.length();
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
