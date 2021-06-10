package com.anirban.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {

  private Integer key;

  private Integer value;

  public Pair(Integer key, Integer value) {
    this.key = key;
    this.value = value;
  }

  public Integer getKey() {
    return key;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}


public class KClosestNumbers {

  public static void main(String[] args) {
    int arr[] = { -10, -50, 20, 17, 80 };
    int x = 20, k = 2;
    int n = arr.length;

    printKclosest(arr, n, x, k);
  }

  private static void printKclosest(int[] arr, int n, int x, int k) {
    //HashMap<Integer, Integer> hm = new HashMap<>();
    ////PriorityQueue<Integer>pq =new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(new Comparator<Pair>() {

      @Override
      public int compare(Pair o1, Pair o2) {
        return o1.getValue().compareTo(o2.getValue());
      }
    });
    for (int i = 0; i < n; i++) {
      int diff = Math.abs(arr[i] - x);
      maxHeap.add(new Pair(diff, arr[i]));
      if (maxHeap.size() > k)
        maxHeap.poll();
    }
    while (maxHeap.size() > 0) {
      System.out.println(maxHeap.peek().getValue());
      maxHeap.poll();
    }

  }
}
