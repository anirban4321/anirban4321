package com.anirban.recursion;

import java.util.ArrayList;
import java.util.Scanner;

class GFG {

  // public static boolean flag = false;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    /*int n = 10;
    ArrayList<Integer> list = new ArrayList<>();
    int target = n;
    list.add(n);
    //list.add(n - 5);
    int index = 1;
    solve(n - 5, list, target);
    System.out.println(list);*/
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      ArrayList<Integer> list = new ArrayList<>();
      int target = n;
      list.add(n);
      solve(n - 5, list, target, false);
      System.out.println(list);
      list.clear();
    }
  }

  static void solve(int N, ArrayList<Integer> list, int target, boolean flag) {
    if (N == target) {
      list.add(N);
      //System.out.print(N);
      return;
    }
    list.add(N);
    // System.out.print(N + " ");
    if (N <= 0 || flag == true) {
      flag = true;
      solve(N + 5, list, target, true);
    }
    if (flag == false)
      solve(N - 5, list, target, false);
  }
}
