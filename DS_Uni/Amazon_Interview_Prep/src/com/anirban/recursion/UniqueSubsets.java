package com.anirban.recursion;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

class UniqueSubsets {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //testcases
    int t = sc.nextInt();

    while (t-- > 0) {
      int size = sc.nextInt();

      Vector<Integer> ip = new Vector<>();
      for (int i = 0; i < size; i++) {
        int element = sc.nextInt();
        ip.add(element);
      }

      Vector<Integer> op = new Vector<>();
      op.clear();
      Set<Vector<Integer>> mp = new HashSet<>();
      mp.clear();
      solve(ip, op, mp);
      if (mp.size() == 0)
        System.out.println("Empty");
      else {
        Iterator it = mp.iterator();
        while (it.hasNext()) {
          Vector<Integer> v = (Vector<Integer>) it.next();
          System.out.print('(');
          boolean first = true;
          for (int i = 0; i < v.size(); i++) {
            if (first == true) {
              System.out.print(v.get(i));
              first = false;
            } else {
              System.out.print(" " + v.get(i));
            }
          }
          System.out.print(')');
        }
      }
    }
  }

  private static void solve(Vector<Integer> ip, Vector<Integer> op, Set<Vector<Integer>> mp) {
    if (ip.size() == 0) {
      Collections.sort(op);
      mp.add(op);
      return;
    }
    System.out.println(op);
    Vector<Integer> op1 = op;
    System.out.println("op1: " + op1);
    Vector<Integer> op2 = op;
    op2.add(ip.get(0));
    ip.remove(ip.get(0));
    System.out.println("op2: " + op2);
    solve(ip, op1, mp);
    solve(ip, op2, mp);
    return;
  }

}
