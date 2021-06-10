package com.anirban.Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFreqNumbers {

  public static void main(String[] args) {
    int arr[] = { 3, 1, 4, 4, 5, 2, 6, 1, 2, 2 };
    //  int arr[] = {};
    int n = arr.length;
    int k = 3;
    print_N_mostFrequentNumber(arr, n, k);
  }

  private static void print_N_mostFrequentNumber(int[] arr, int n, int k) {
    Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
    if (n == 0) {
      System.out.println(0);
      return;
    }
    for (int i = 0; i < n; i++)
      mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {

      @Override
      public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o1.getValue().compareTo(o2.getValue());
      }
    });
    for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
      minHeap.add(entry);
      if (minHeap.size() > k)
        minHeap.poll();
    }
    for (int i = 0; i < k; i++)
      System.out.println(minHeap.poll().getKey());
  }

}
