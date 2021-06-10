package com.anirban.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class PhoneDigit {

  public static void main(String[] args) {
    int a[] = { 2, 3, 4 };
    int N = 3;
    ArrayList<String> ans = possibleWords(a, N);
    System.out.println(ans);
  }

  static ArrayList<String> possibleWords(int a[], int N) {
    HashMap<Integer, String> map = new HashMap<Integer, String>();
    generateMap(map);
    ArrayList<String> list = new ArrayList<>();
    String op = "";
    list = solve(map, a, N, 0, op);
    return list;
  }

  static ArrayList<String> solve(
      HashMap<Integer, String> map, int[] a, int N, int index, String op) {

    if (index == N) {
      return new ArrayList<String>(Collections.singleton(op));
    }
    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < map.get(a[index]).length(); i++) {
      String sCopy = String.copyValueOf(op.toCharArray());
      sCopy = sCopy.concat(String.valueOf(map.get(a[index]).charAt(i)));
      //op += String.valueOf(map.get(a[index]).charAt(i));
      list.addAll(solve(map, a, N, index + 1, sCopy));
    }
    return list;
  }

  static void generateMap(HashMap<Integer, String> map) {
    map.put(0, "");
    map.put(1, "");
    map.put(2, "ABC");
    map.put(3, "DEF");
    map.put(4, "GHI");
    map.put(5, "JKL");
    map.put(6, "MNO");
    map.put(7, "PQRS");
    map.put(8, "TUV");
    map.put(9, "WXYZ");
  }
}
