package com.anirban.slidingwindow;

import java.util.HashMap;

public class LongestSubstringwithNoRepeatingChars {

  public static void main(String[] args) {
    String s = "abcabcbb";
    System.out.println(lengthOfLongestSubstring(s));
  }

  public static int lengthOfLongestSubstring(String s) {
    int len = s.length();
    int i = 0;
    int j = 0;
    int max = -1;
    HashMap<Character, Integer> map = new HashMap<>();
    while (j < len) {
      if (map.containsKey(s.charAt(j)))
        map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
      else
        map.put(s.charAt(j), 1);
      if (map.size() == j - i + 1) {
        max = Math.max(max, j - i + 1);
        j++;
      } else if (map.size() < j - i + 1) {
        while (map.size() < j - i + 1) {
          if (map.containsKey(s.charAt(i)))
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
