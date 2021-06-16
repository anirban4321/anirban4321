package DS_Uni.Amazon_Interview_Prep.src.com.anirban.dynamicprogramming.lcs;

import java.util.ArrayList;

public class EditDistance {

  public static void main(String[] args) {
   // String s = "geek", t = "gesek";
    String s = "horse", t = "ros";
    System.out.println(editDistance(s,t));
  }
  public static int editDistance(String s, String t) {
    int m = s.length();
    int n = t.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0)
          dp[i][j] = j;
        if (j == 0)
          dp[i][j] = i;
      }
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (s.charAt(i - 1) == t.charAt(j - 1))
          dp[i][j] = dp[i - 1][j - 1];
        else {
          int result = Math.min(dp[i - 1][j], dp[i][j - 1]);//rempve and insert
          dp[i][j] = 1 + Math.min(result, dp[i - 1][j - 1]);//replace
        }
      }
    }

    int N = dp[m][n];
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
    ArrayList<String> list = new ArrayList<>();
    int i = m;
    int j = n;
    while (i >0 && j > 0) {
      if (i == 0 || j == 0) {
        break;
      }
      if (s.charAt(i - 1) == t.charAt(j - 1)) {
        i--;
        j--;
      } else if (dp[i][j] == dp[i - 1][j - 1] + 1) {
        list.add("replace");
        i--;
        j--;
      } else if (dp[i][j] == dp[i - 1][j] + 1) {
        list.add("Remove");
        i--;
      } else if (dp[i][j] == dp[i][j - 1] + 1) {
        list.add("Insert");
        j--;
      }
    }
    System.out.println(list);
    return dp[m][n];
 }
}