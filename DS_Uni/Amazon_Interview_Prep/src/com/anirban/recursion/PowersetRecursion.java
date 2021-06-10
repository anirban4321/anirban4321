package com.anirban.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PowersetRecursion {

  ArrayList<String> result = new ArrayList<>();

  public static void main(String[] args) {
    //    String ip = "abc";
    //    ArrayList<String> result1 = powerSet(ip);
    //    result1.sort(String::compareTo);
    //    System.out.println(result1);

    Scanner sc = new Scanner(System.in);
    //testcases
    int t = sc.nextInt();

    while (t-- > 0) {
      //input string
      String st = sc.next();

      //calling powerSet() function
      ArrayList<String> ans = powerSet(st);

      //sorting the result of the powerSet() function
      Collections.sort(ans);

      //printing the result
      for (String s : ans)
        System.out.print(s + " ");
      System.out.println();
    }
  }

  // complete the function
  static ArrayList<String> powerSet(String s) {
    String output = "";
    ArrayList<String> result = new ArrayList<>();
    return solve(s, output, result);
  }

  static ArrayList<String> solve(String ip, String op, ArrayList<String> result) {
    if (ip.length() == 0) {
      result.add(op);
      return result;
    }
    String op1 = op;
    String op2 = op;
    op2 += String.valueOf(ip.charAt(0));
    System.out.println("op1: " + op1);
    System.out.println("op2: " + op2);
    ip = new StringBuffer(ip).delete(0, 1).toString();
    solve(ip, op1, result);
    solve(ip, op2, result);
    return result;
  }
}
