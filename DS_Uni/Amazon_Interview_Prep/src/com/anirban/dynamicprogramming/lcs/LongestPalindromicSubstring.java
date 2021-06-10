package com.anirban.dynamicprogramming.lcs;

/*
Given a string, find the longest substring which is palindrome.
For example,

Input: Given string :"forgeeksskeegfor",
Output: "geeksskeeg"

Input: Given string :"Geeks",
Output: "ee"
 */
public class LongestPalindromicSubstring {

  public static void main(String[] args) {
    String str = "forgeeksskeegfor";
    String revString = new StringBuilder(str).reverse().toString();
    System.out.println("Length is: " + longestPalSubstr(str, revString, str.length()));
  }

  private static int longestPalSubstr(String a, String b, int m) {
    int result[][] = new int[m + 1][m + 1];
    int ans = 0;
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < m + 1; j++) {
        if (i == 0 || j == 0)
          result[i][j] = 0;
      }
    }

    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
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
