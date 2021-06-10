package com.anirban.slidingwindow;

import java.util.HashMap;

public class PickToys {

  public static void main(String[] args) {
    String s = "abaccab";
    System.out.println(maxPickToys(s));
  }

  private static int maxPickToys(String s) {
    int i = 0;
    int j = 0;
    int max = 0;
    int len = s.length();
    HashMap<Character, Integer> map = new HashMap<>();
    while (j < len) {
      if (map.containsKey(s.charAt(j)))
        map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
      else
        map.put(s.charAt(j), 1);
      if (map.size() < 2) {
        j++;
      }
      if (map.size() == 2) {
        max = Math.max(max, j - i + 1);
        j++;
      } else if (map.size() > 2) {
        while (map.size() > 2) {
          map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
          if (map.get(s.charAt(i)) == 0)
            map.remove(s.charAt(i));
          i++;
        }
        j++;
      }
    }
    return max;
  }
}
