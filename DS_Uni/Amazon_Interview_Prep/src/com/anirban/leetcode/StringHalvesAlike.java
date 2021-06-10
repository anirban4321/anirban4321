package com.anirban.leetcode;

public class StringHalvesAlike {

  public static void main(String[] args) {
    String s = "book";
    System.out.println(halvesAreAlike(s));
  }

  public static int countVowels(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'
          || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U')
        count++;
    }
    return count;
  }

  public static boolean halvesAreAlike(String s) {
    int length = s.length();
    int mid = (length - 0) / 2;
    System.out.println(mid);
    String firstHalf = s.substring(0, mid);
    String secondHalf = s.substring(mid, length);
    if (countVowels(firstHalf) == countVowels(secondHalf))
      return true;
    return false;
  }
}
