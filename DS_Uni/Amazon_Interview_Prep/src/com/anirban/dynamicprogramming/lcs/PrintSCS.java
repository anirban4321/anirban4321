package com.anirban.dynamicprogramming.lcs;

public class PrintSCS {

  private static int t[][];

  public static void main(String[] args) {
    String a = "AGGTAB";
    String b = "GXTXAYB";
    int m = a.length();
    int n = b.length();
    String scs = printSCS(a, b, m, n);
    System.out.println(scs);
  }

  private static String printSCS(String a, String b, int m, int n) {
    LCS(a, b, m, n);
    int i = m;
    int j = n;
    StringBuilder str = new StringBuilder();
    while (i > 0 && j > 0) {
      if (a.charAt(i - 1) == b.charAt(j - 1)) {
        str.append(a.charAt(i - 1));
        i--;
        j--;
      } else {
        if (t[i - 1][j] > t[i][j - 1]) {
          str.append(a.charAt(i - 1));
          i--;
        } else {
          str.append(b.charAt(j - 1));
          j--;
        }
      }
    }
    while (i > 0) {
      str.append(a.charAt(i - 1));
      i--;
    }
    while (j > 0) {
      str.append(b.charAt(j - 1));
      j--;
    }
    return str.reverse().toString();
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
