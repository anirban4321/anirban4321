package com.anirban.dynamicprogramming.lcs;

import java.util.Scanner;

public class CandidateCode {

  public static void main(String args[]) throws Exception {

    Scanner sc = new Scanner(System.in);
    String virus = sc.next();
    int personCount = sc.nextInt();
    String bloodCompostion;
    for (int i = 0; i < personCount; i++) {
      bloodCompostion = sc.next();
      int virusLength = virus.length();
      int bloodCompostionLength = bloodCompostion.length();
      if (isSubSequence(bloodCompostion, virus, bloodCompostionLength, virusLength))
        System.out.println("POSITIVE");
      else
        System.out.println("NEGATIVE");
    }
  }

  static boolean isSubSequence(
      String str1, String str2, int m, int n) {
    if (m == 0)
      return true;
    if (n == 0)
      return false;

    if (str1.charAt(m - 1) == str2.charAt(n - 1))
      return isSubSequence(str1, str2, m - 1, n - 1);

    return isSubSequence(str1, str2, m, n - 1);
  }
}