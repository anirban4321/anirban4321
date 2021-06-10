package com.anirban.Stack;

import java.util.Stack;

public class NGR {

  public static void main(String[] args) {
    long arr[] = { 1, 3, 2, 4 };
    long result[] = nextLargerElement(arr, arr.length);
    for (long i : result)
      System.out.println(i);
  }

  public static long[] nextLargerElement(long[] arr, int n) {
    long[] v = new long[n];
    Stack<Long> s = new Stack<>();
    for (int i = arr.length - 1; i >= 0; i--) {
      if (s.size() == 0)
        v[i] = -1;
      if (s.size() > 0 && s.peek() >= arr[i])
        v[i] = s.peek();
      if (s.size() > 0 && s.peek() <= arr[i]) {
        while (s.size() > 0 && s.peek() <= arr[i])
          s.pop();
        if (s.size() == 0)
          v[i] = -1;
        else
          v[i] = s.peek();
      }
      s.push(arr[i]);
    }
        /*for (int i = 0; i < n / 2; i++) {
            long t = v[i];
            v[i] = v[n - i - 1];
            v[n - i - 1] = t;
        }*/
    return v;
  }
}
