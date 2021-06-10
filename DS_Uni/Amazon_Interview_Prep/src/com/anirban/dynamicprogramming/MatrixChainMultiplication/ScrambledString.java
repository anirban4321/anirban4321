package com.anirban.dynamicprogramming.MatrixChainMultiplication;

public class ScrambledString {

  public static void main(String[] args) {
    String a = "great";
    String b = "ategr";
    System.out.println(isScrambled(a, b));
  }

  private static boolean isScrambled(String a, String b) {
    if (a.length() != b.length())
      return false;
    if (a.isEmpty() && b.isEmpty())
      return true;
    if (a.length() < 1 || b.length() < 1)
      return false;
    if (a.compareTo(b) == 0)
      return true;
    boolean flag = false;
    int length = a.length();
    boolean condition1;
    boolean condition2;
    for (int i = 1; i <= length - 1; i++) {
      String secondPartOfBString = b.substring(length - i, i);
      String firstPartOfBString = b.substring(0, length - i);
      System.out.println(secondPartOfBString);
      //if swapping happens
      condition1 = (isScrambled(a.substring(0, i), secondPartOfBString) == true
          && isScrambled(a.substring(i, length - i), firstPartOfBString) == true);
      //if swapping doesnot happen
      condition2 = (isScrambled(a.substring(0, i), b.substring(0, i)) == true
          && isScrambled(a.substring(i, length - i), b.substring(i, length - i)) == true);
      if (condition1 == true || condition2 == true) {
        flag = true;
        break;
      }
    }
    return flag;
  }
}
