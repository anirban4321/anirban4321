package com.anirban.dynamicprogramming.lcs;

/*
Given two strings ‘str1’ and ‘str2’ of size m and n respectively. The task is to remove/delete and insert the minimum number of characters from/in str1 to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.

Example 1:

Input :
str1 = "heap", str2 = "pea"
Output :
Minimum Deletion = 2 and
Minimum Insertion = 1
Explanation:
p and h deleted from heap
Then, p is inserted at the beginning
One thing to note, though p was required yet
it was removed/deleted first from its position and
then it is inserted to some other position.
Thus, p contributes one to the deletion_count
and one to the insertion_count.
 */
public class MinInsDel {

  public static void main(String[] args) {
    String str1 = new String("heap");
    String str2 = new String("pea");

    // Function Call
    printMinDelAndInsert(str1, str2);
  }

  private static void printMinDelAndInsert(String str1, String str2) {
    int lcs = findLcs(str1, str2, str1.length(), str2.length());
    int numberOfDel = str1.length() - lcs;
    int numberOfIns = str2.length() - lcs;
    System.out.println(numberOfDel + ":" + numberOfIns);
  }

  private static int findLcs(String a, String b, int m, int n) {
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
