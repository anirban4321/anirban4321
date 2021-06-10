package com.anirban.slidingwindow;

import java.util.LinkedList;

public class FirstNegNumKSizeWindow {

  public static void main(String[] args) {
    int[] array = { 12, -1, -7, 8, -15, 30, 16, 28 };
    int k = 3;
    findFirstNegNum(array, k);
  }

  private static void findFirstNegNum(int[] array, int k) {
    LinkedList<Integer> list = new LinkedList<>();
    int j = 0;
    int i = 0;
    while (j < array.length) {
      if (array[j] < 0)
        list.add(array[j]);
      if (j - i + 1 < k)
        j++;
      else if (j - i + 1 == k) {
        if (list.size() == 0)
          System.out.print(0 + " ");
        else {
          System.out.print(list.peekFirst() + " ");
          if (array[i] == list.peek()) {
            int item = list.peek();
            list.remove(item);
          }
        }
        i++;
        j++;
      }
    }
  }
}