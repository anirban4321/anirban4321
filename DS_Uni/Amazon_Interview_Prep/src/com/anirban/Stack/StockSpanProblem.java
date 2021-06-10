package com.anirban.Stack;

import java.util.Stack;

public class StockSpanProblem {

  public static void main(String[] args) {
    int price[] = { 10, 4, 5, 90, 120, 80 };
    int result[] = calculateSpan(price, price.length);
    for (int i : result)
      System.out.println(i);
  }

  //Function to calculate the span of stockâ€™s price for all n days.
  public static int[] calculateSpan(int price[], int n) {
    int[] result = new int[n];
    Stack<Pair> s = new Stack<>();
    for (int i = 0; i < price.length; i++) {
      if (s.size() == 0)
        result[i] = -1;
      if (s.size() > 0 && s.peek().element >= price[i])
        result[i] = s.peek().index;
      if (s.size() > 0 && s.peek().element <= price[i]) {
        while (s.size() > 0 && s.peek().element <= price[i])
          s.pop();
        if (s.size() == 0)
          result[i] = -1;
        else
          result[i] = s.peek().index;
      }
      s.push(new Pair(price[i], i));
    }
    for (int i = 0; i < n; i++) {
      System.out.print(result[i] + " ");
    }
    System.out.println(0);
    for (int i = 0; i < n; i++) {
      result[i] = i - result[i];
    }
    /*for (int i = 0; i < n; i++) {
      result[i] = i - result[i];
    }*/
    return result;
  }

  static class Pair {

    int element;

    int index;

    Pair(int element, int index) {
      this.element = element;
      this.index = index;
    }
  }
}
