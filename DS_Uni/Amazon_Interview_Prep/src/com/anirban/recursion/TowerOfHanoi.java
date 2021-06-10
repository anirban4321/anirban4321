package com.anirban.recursion;

public class TowerOfHanoi {

  private static int count = 0;

  public static void main(String[] args) {
    int numberOfDisk = 3;
    int result = towerOfHanoi("A", "C", "B", numberOfDisk, count);
    System.out.println(result);
  }

  public static int towerOfHanoi(String src, String dst, String helper, int numberOfDisk, int count) {
    count++;
    if (numberOfDisk == 1) {
      System.out.println("Move disk " + numberOfDisk + " from " + src + " to " + dst);
      return count;
    }
    count = towerOfHanoi(src, helper, dst, numberOfDisk - 1, count);
    System.out.println("Move disk " + numberOfDisk + " from " + src + " to " + dst);
    count = towerOfHanoi(helper, dst, src, numberOfDisk - 1, count);
    return count;
  }

}
