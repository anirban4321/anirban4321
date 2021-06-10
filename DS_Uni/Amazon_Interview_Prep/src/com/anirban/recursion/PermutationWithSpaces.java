package com.anirban.recursion;

import java.util.Scanner;

class PermutationWithSpaces {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //testcases
    int t = sc.nextInt();

    while (t-- > 0) {
      String s = sc.next();
      String op = "";
      op += String.valueOf(s.charAt(0));
      s = new StringBuffer(s).delete(0, 1).toString();
      solve(s, op);
      System.out.println();
    }
  }

  private static void solve(String ip, String op) {
    if (ip.length() == 0) {
      System.out.print("(" + op + ")");
      return;
    }
    String op1 = op;
    String op2 = op;
    op1 += " ";
    op1 += String.valueOf(ip.charAt(0));
    op2 += String.valueOf(ip.charAt(0));
    ip = new StringBuffer(ip).delete(0, 1).toString();
    solve(ip, op1);
    solve(ip, op2);
  }
}
