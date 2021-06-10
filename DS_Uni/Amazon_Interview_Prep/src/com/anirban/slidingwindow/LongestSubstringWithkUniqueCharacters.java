package com.anirban.slidingwindow;

import java.util.HashMap;

public class LongestSubstringWithkUniqueCharacters {

  public static void main(String[] args) {
    String s = "aabacbebebe";
    int k = 3;
    System.out.println(findLengthOfLongSubstring(s, k));
  }

  private static int findLengthOfLongSubstring(String s, int k) {
    int len = s.length();
    int i = 0;
    int j = 0;
    int max = 0;
    HashMap<Character, Integer> mp = new HashMap<>();
    while (j < len) {
      if (mp.containsKey(s.charAt(j)))
        mp.put(s.charAt(j), mp.get(s.charAt(j)) + 1);
      else
        mp.put(s.charAt(j), 1);
      if (mp.size() < k)
        j++;
      else if (mp.size() == k) {
        max = Math.max(max, j - i + 1);
        j++;
      } else if (mp.size() > k) {
        while (mp.size() > k && i < len) {
          mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
          if (mp.get(s.charAt(i)) == 0)
            mp.remove(s.charAt(i));
          i++;
        }
        j++;
      }
    }
    return max;
  }
}
