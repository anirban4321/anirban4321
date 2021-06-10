package com.anirban.Heap;

import java.util.PriorityQueue;

public class KLargestElements {

  public static void main(String[] args) {
    int arr[] = {
        11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };

    int size = arr.length;

    // Size of Min Heap
    int k = 3;

    firstKLargestelements(arr, size, k);
  }

  private static void firstKLargestelements(int[] arr, int size, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    for (int i = 0; i < size; i++) {
      minHeap.add(arr[i]);
      if (minHeap.size() > k)
        minHeap.poll();
    }
    while (!minHeap.isEmpty()) {
      System.out.println(minHeap.peek());
      minHeap.poll();
    }
  }
}
