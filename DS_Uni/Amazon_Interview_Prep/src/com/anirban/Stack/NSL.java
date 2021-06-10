package com.anirban.Stack;

import java.util.Stack;

public class NSL {

  public static void main(String[] args) {
    long arr[] = { 1, 3, 2, 4 };
    long result[] = nextSmallerLeftElement(arr, arr.length);
    for (long i : result)
      System.out.println(i);
  }

  private static long[] nextSmallerLeftElement(long[] arr, int n) {
    long[] v = new long[n];
    Stack<Long> s = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (s.size() == 0)
        v[i] = -1;
      if (s.size() > 0 && s.peek() <= arr[i])
        v[i] = s.peek();
      if (s.size() > 0 && s.peek() >= arr[i]) {
        while (s.size() > 0 && s.peek() >= arr[i])
          s.pop();
        if (s.size() == 0)
          v[i] = -1;
        else
          v[i] = s.peek();
      }
      s.push(arr[i]);
    }
    return v;
  }
}
