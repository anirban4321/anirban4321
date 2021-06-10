package com.anirban.Stack;

import java.util.Stack;

class Pair1 {

  int element;

  int index;

  Pair1(int element, int index) {
    this.element = element;
    this.index = index;
  }
}


public class MaxAreaHistogram {

  public static void main(String[] args) {
    int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
    System.out.println(MaxAreaUtil(hist));
  }

  private static int MaxAreaUtil(int[] result) {
    int[] right = NSR(result);
    int[] left = NSL(result);
    int[] width = new int[result.length];
    int[] area = new int[result.length];
    for (int i = 0; i < result.length; i++) {
      width[i] = right[i] - left[i] - 1;
    }
    for (int i = 0; i < result.length; i++)
      area[i] = width[i] * result[i];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < area.length; i++)
      max = Math.max(max, area[i]);
    return max;
  }

  private static int[] NSR(int[] result) {
    int len = result.length;
    int[] ans = new int[len];
    Stack<Pair1> s = new Stack<>();
    for (int i = len - 1; i >= 0; i--) {
      if (s.isEmpty())
        ans[i] = len + 1;
      if (s.size() > 0 && s.peek().element <= result[i])
        ans[i] = s.peek().index;
      if (s.size() > 0 && s.peek().element >= result[i]) {
        while (s.size() > 0 && s.peek().element >= result[i]) {
          s.pop();
        }
        if (s.size() == 0)
          ans[i] = len + 1;
        else
          ans[i] = s.peek().index;
      }
      s.push(new Pair1(result[i], i));
    }
    return ans;
  }

  private static int[] NSL(int[] result) {
    int len = result.length;
    int[] ans = new int[len];
    Stack<Pair1> s = new Stack<>();
    for (int i = 0; i < len; i++) {
      if (s.isEmpty())
        ans[i] = -1;
      if (s.size() > 0 && s.peek().element <= result[i])
        ans[i] = s.peek().index;
      if (s.size() > 0 && s.peek().element >= result[i]) {
        while (s.size() > 0 && s.peek().element >= result[i]) {
          s.pop();
        }
        if (s.size() == 0)
          ans[i] = -1;
        else
          ans[i] = s.peek().index;
      }
      s.push(new Pair1(result[i], i));
    }
    return ans;
  }
}
