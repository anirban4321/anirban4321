package com.anirban.dynamicprogramming.lcs;

import java.util.Stack;

public class PrintLCS {

  private static int t[][];

  public static void main(String[] args) {
    String a = "waterrfetawx";
    String b = "xwatefrretaw";
    int m = a.length();
    int n = b.length();
    printLCS(a, b, m, n);
  }

  private static void printLCS(String a, String b, int m, int n) {
    LCS(a, b, m, n);
    int i = m;
    int j = n;
    Stack<Character> str = new Stack<>();
    while (i > 0 && j > 0) {
      if (a.charAt(i - 1) == b.charAt(j - 1)) {
        str.push(a.charAt(i - 1));
        i--;
        j--;
      } else {
        if (t[i][j - 1] > t[i - 1][j])
          j--;
        else
          i--;
      }
    }
    while (!str.isEmpty())
      System.out.print(str.pop());

  }

  private static void LCS(String a, String b, int m, int n) {
    t = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        if (i == 0 || j == 0)
          t[i][j] = 0;
      }
    }

    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (a.charAt(i - 1) == b.charAt(j - 1))
          t[i][j] = 1 + t[i - 1][j - 1];
        else
          t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
      }
    }
  }

}
