package com.anirban.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

  public static void main(String[] args) {
    int arr[] = {
        11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };

    int size = arr.length;

    // Size of Min Heap
    int k = 3;

    kthSmallestelement(arr, size, k);
  }

  private static void kthSmallestelement(int[] arr, int size, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    for (int i = 0; i < size; i++) {
      maxHeap.add(arr[i]);
      if (maxHeap.size() > k)
        maxHeap.poll();
    }
    System.out.println(maxHeap.peek());
  }

}
