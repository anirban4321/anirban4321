package com.anirban.leetcode;

public class MoneyInLeetCodeBank {

  public static void main(String[] args) {
    int n = 10;
    System.out.println(totalMoney(n));
  }

  public static int totalMoney(int n) {
    int i = 1;
    int sum = 0;
    int rem = 0;
    if (n <= 7) {
      for (int monday = 1; monday <= n; monday++) {
        sum = sum + monday;
      }
    } else {
      rem = n % 7;
      for (int monday = 1; monday <= 7; monday++) {
        sum = sum + monday;
      }
      if (rem != 0) {
        i += 1;
        sum += i;
        for (int j = i + 1; j <= rem + 1; j++)
          sum += j;
      }
    }
    return sum;
  }
}

