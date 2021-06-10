package com.anirban.recursion;

import java.util.ArrayList;

class OnesGreaterThanZeroes {

  public static void main(String[] args) {
    int N = 3;
    ArrayList<String> ans = new OnesGreaterThanZeroes().NBitBinary(N);
    System.out.println(ans);
  }

  static void solve(int ones, int zeroes, int N, String op, ArrayList<String> result) {
    if (N == 0) {
      result.add(op);
      return;
    }
    String op1 = op;
    op1 += "1";
    solve(ones + 1, zeroes, N - 1, op1, result);
    if (ones > zeroes) {
      String op2 = op;
      op2 += "0";
      solve(ones, zeroes + 1, N - 1, op2, result);
    }
  }

  ArrayList<String> NBitBinary(int N) {
    String op = "";
    int ones = 0;
    int zeroes = 0;
    ArrayList<String> result = new ArrayList<>();
    solve(ones, zeroes, N, op, result);
    return result;
  }
}
