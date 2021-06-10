package com.anirban.recursion;

import java.util.HashMap;
import java.util.Map;

public class Frequency {

  public static void main(String[] args) {
    int[] arr = { 2, 3, 2, 3, 5 };
    int n = 5;
    frequencycount(arr, n);
  }

  public static void frequencycount(int arr[], int n) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 1; i <= n; i++) {
      map.put(i, 0);
    }
    for (int i = 1; i <= n; i++) {
      if (map.containsKey(arr[i - 1])) {
        map.put(arr[i - 1], map.get(arr[i - 1]) + 1);
      }
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      System.out.print(entry.getValue() + " ");
    }
    System.out.println();

  }
}
