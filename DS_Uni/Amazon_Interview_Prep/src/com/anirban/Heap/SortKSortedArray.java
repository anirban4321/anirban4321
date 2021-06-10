package com.anirban.Heap;

import java.util.PriorityQueue;

public class SortKSortedArray {

  public static void main(String[] args) {
    int k = 3;
    //int arr[] = { 2, 6, 3, 12, 56, 8 };
    int arr[] = { 6, 5, 3, 2, 8, 10, 9 };
    int n = arr.length;
    kSort(arr, n, k);
    /*System.out.println("Following is sorted array");
    printArray(arr, n);*/
  }

  private static void kSort(int[] arr, int n, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      minHeap.add(arr[i]);
    }
    while (minHeap.size() != 0) {
      System.out.print(minHeap.peek() + " ");
      minHeap.poll();
    }
  }

}
