package com.anirban.Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

  public static void main(String[] args) {
    int[] array = { 4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5 };
    int arr[] = { 2, 5, 2, 8, 5, 6, 8, 8 };
    int n = arr.length;
    sortFrequency(arr, n);
  }

  private static void sortFrequency(int[] array, int n) {
    Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
    for (int i = 0; i < n; i++)
      mp.put(array[i], mp.getOrDefault(array[i], 0) + 1);

    PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<Map.Entry<Integer, Integer>>(new Comparator<Map.Entry<Integer, Integer>>() {

      @Override
      public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o1.getValue().compareTo(o2.getValue());
      }
    });
    for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
      // System.out.println(entry);
      maxHeap.add(entry);

    }
    // System.out.println(maxHeap.size());
    while (maxHeap.size() > 0) {
      // System.out.println(maxHeap.peek());
      int freq = maxHeap.peek().getValue();
      // System.out.println("freq " + freq);
      int element = maxHeap.peek().getKey();
      // System.out.println("element " + element);
      for (int i = 1; i <= freq; i++) {
        System.out.println(element);
      }
      maxHeap.poll();
    }
  }

}
