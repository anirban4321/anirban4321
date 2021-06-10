/*
package com.anirban.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReachANumber {

  public static void main(String[] args) {
    System.out.println(reachNumber(2));
  }

  public static int reachNumber(int target) {
    Queue<Integer> q = new ArrayDeque<>();
    int start = 0;
    q.add(start);
    int i = 0;
    //int index=0;
    int lIndex = 0;
    int rIndex = 0;

    while (lIndex == target || rIndex == target) {
      i++;
      lIndex = lIndex - i;
      rIndex =;
    }

    //    while (!q.isEmpty()) {
    while (true) {
      //        int index = q.poll();
      i++;
      lIndex = lIndex - i;
      rIndex = rIndex + i;
      //        q.add(lIndex);
      //        q.add(rIndex);
      if (lIndex == target || rIndex == target) {
        break;
      }
    }

    //}
    return i;
  }
}
*/
