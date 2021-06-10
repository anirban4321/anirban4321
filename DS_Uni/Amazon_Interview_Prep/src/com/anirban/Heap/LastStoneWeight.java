package com.anirban.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

  public static void main(String[] args) {
    int a[] = { 2, 7, 4, 1, 8, 1 };
    System.out.println(lastStoneWeight(a));
  }

  public static int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    int size = stones.length;
    for (int i = 0; i < size; i++) {
      maxHeap.add(stones[i]);
    }
    int first = 0;
    int second = 0;
    while (size > 1) {
      first = maxHeap.peek();
      maxHeap.poll();
      second = maxHeap.peek();
      maxHeap.poll();
      size -= 2;
      int diff = Math.abs(first - second);
      if (diff > 0) {
        maxHeap.add(diff);
        size++;
      }
    }
    if (maxHeap.size() != 0)
      return maxHeap.peek();
    return 0;
  }
}
