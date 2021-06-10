package com.anirban.recursion;

import java.util.ArrayList;
import java.util.List;

class LetterCasePermutation {

  public static void main(String[] args) {
    String S = "a1b2";
    List<String> ans = letterCasePermutation(S);
    System.out.println(ans);
  }

  private static boolean isCharacter(char ch) {
    if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
      return true;
    else
      return false;
  }

  private static void solve(String ip, String op, List<String> result) {
    if (ip.length() == 0) {
      result.add(op);
      return;
    }
    if (isCharacter(ip.charAt(0))) {
      String op1 = op;
      String op2 = op;
      op1 += String.valueOf(ip.charAt(0)).toLowerCase();
      op2 += String.valueOf(ip.charAt(0)).toUpperCase();
      ip = new StringBuffer(ip).delete(0, 1).toString();
      solve(ip, op1, result);
      solve(ip, op2, result);
    } else {
      String op1 = op;
      op1 += String.valueOf(ip.charAt(0));
      ip = new StringBuffer(ip).delete(0, 1).toString();
      solve(ip, op1, result);
    }
  }

  public static List<String> letterCasePermutation(String S) {
    String ip = S;
    String op = "";
    List<String> result = new ArrayList<>();
    solve(ip, op, result);
    return result;
  }
}
