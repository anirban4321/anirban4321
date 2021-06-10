package com.anirban.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class SumOfEleBetwKthAndK1thSmallest {

  public static void main(String[] args) {
    int[] arr = { 20, 8, 22, 4, 12, 10, 14 };
    int size = arr.length;
    int k1 = 3;
    int k2 = 6;
    findSum(arr, k1, k2, size);
  }

  private static void findSum(int[] arr, int k1, int k2, int size) {
    int first = findSmallest(arr, k1, size);
    int second = findSmallest(arr, k2, size);
    int sum = 0;
    for (int i = 0; i < size; i++) {
      if (arr[i] > first && arr[i] < second)
        sum = sum + arr[i];
    }
    System.out.println(sum);
  }

  private static int findSmallest(int[] arr, int k, int size) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < size; i++) {
      maxHeap.add(arr[i]);
      if (maxHeap.size() > k)
        maxHeap.poll();
    }
    return maxHeap.peek();
  }
}
