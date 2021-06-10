package com.anirban.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

public class MaxOfAllSubarraySizeK {

  public static void main(String[] args) {
    //int[] array = { 1, 3, -1, -3, 5, 3, 6, 7 };
    int[] array = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
    int size = array.length;
    int k = 3;
    slidingMaxOfSubarray(array, size, k);
  }

  private static void slidingMaxOfSubarray(int[] array, int size, int k) {
    Deque<Integer> list = new LinkedList<>();
    int i = 0;
    int j = 0;
    while (j < size) {
      while (list.size() > 0 && list.peekLast() < array[j]) {
        list.removeLast();
      }
      list.addLast(array[j]);
      if (j - i + 1 < k)
        j++;
      if (j - i + 1 == k) {
        System.out.print(list.peekFirst() + " ");
        if (list.peekLast() == array[i]) {
          //System.out.println(list.peekLast() + " ");
          list.removeLast();
        }
        i++;
        j++;
      }
    }
  }
}
